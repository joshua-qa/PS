/**
 * 1076ms faster than 5.49% ㅋㅋㅋㅋㅋㅋㅋㅋㅋ 아.. 7ms로 푼 사람도 있네..
 */
class Solution {
    public int[] minDifference(int[] nums, int[][] queries) {
        List<TreeSet<Integer>> table = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            table.add(new TreeSet<>());
        }

        int length = nums.length;
        for (int i = 0; i < length; i++) {
            table.get(nums[i]-1).add(i);
        }
        int[] result = new int[queries.length];

        int index = 0;
        for (int[] query : queries) {
            int start = query[0];
            int end = query[1];
            int ans = Integer.MAX_VALUE;

            List<Integer> existList = new ArrayList<>();
            for (int i = 0; i <= 99; i++) {
                Integer upperBound = table.get(i).ceiling(start);
                if (upperBound != null && upperBound <= end) {
                    existList.add(i+1);
                }
            }
            int size = existList.size();
            for (int i = 0; i < size-1; i++) {
                int abs = abs(existList.get(i) - existList.get(i+1));
                if (abs != 0 && abs < ans) {
                    ans = abs;
                }
            }

            result[index++] = (ans == Integer.MAX_VALUE) ? -1 : ans;
        }
        return result;
    }

    private int abs(int num) {
        return num > 0 ? num : -num;
    }
}