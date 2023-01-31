// 111ms. 솔직히 생각해내는게 쉽지 않았지만 자력으로 풀었다 ^.^ 완전 뿌듯하다.
// fenwick tree를 사용하는 풀이는 O(N log N)이 가능하다지만.. DP O(N^2) 풀이가 일반적으로 생각할 수 있는 최선인듯.
class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        Pair<Integer, Integer>[] nums = new Pair[n];
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = new Pair<>(ages[i], scores[i]);
        }
        Arrays.sort(nums, new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                if (o1.getKey().equals(o2.getKey())) {
                    return o1.getValue() - o2.getValue();
                }
                return o1.getKey() - o2.getKey();
            }
        });

        for (int i = 0; i < n; i++) {
            dp[i] = nums[i].getValue();
            for (int j = 0; j < i; j++) {
                if (nums[j].getKey() <= nums[i].getKey() && nums[j].getValue() <= nums[i].getValue()) {
                    dp[i] = Math.max(dp[j] + nums[i].getValue(), dp[i]);
                }
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] > result) {
                result = dp[i];
            }
        }
        return result;
    }
}
