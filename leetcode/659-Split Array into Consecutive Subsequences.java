// 11ms. 미디엄 치고 쫌 어려웠다..
class Solution {
    public boolean isPossible(int[] nums) {
        int length = nums.length;
        int padding = 1000;
        int[] count = new int[2001];
        for (int i = 0; i < length; i++) {
            count[nums[i] + padding]++;
        }
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < 2001; i++) {
            if (count[i] != 0) {
                set.add(i);
            }
        }

        while (!set.isEmpty()) {
            int curr = set.first();
            int seqLength = 0;
            while (true) {
                int prevCount = count[curr];
                count[curr]--;
                seqLength++;
                if (count[curr] == 0) {
                    set.remove(curr);
                }
                curr++;
                if (count[curr] == 0 || count[curr] < prevCount) {
                    break;
                }
            }
            if (seqLength < 3) {
                return false;
            }
        }
        return true;
    }
}
