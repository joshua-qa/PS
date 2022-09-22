// 5ms. 무난한 난이도
class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] result = new int[queries.length];
        int sumEven = 0, resultIndex = 0;
        for (int num : nums) {
            if ((num & 1) == 0) {
                sumEven += num;
            }
        }

        for (int[] query : queries) {
            int index = query[1];
            int before = nums[index];
            nums[index] += query[0];

            // before even, after odd
            if ((nums[index] & 1) == 1) {
                if ((before & 1) == 0) {
                    sumEven -= before;
                }
                result[resultIndex++] = sumEven;
                continue;
            }

            // before even, after even
            // before odd, after even
            if ((before & 1) == 1) {
                sumEven += nums[index];
            } else {
                sumEven += query[0];
            }
            result[resultIndex++] = sumEven;
        }
        return result;
    }
}
