// 5ms. 연속되는 0의 개수에 대해 subarray 개수 구하는 규칙을 알아내면 쉽게 풀 수 있다.
class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long result = 0;
        long curr = 0;
        int index = 0;
        while (index < nums.length) {
            if (nums[index++] == 0) {
                curr++;
                continue;
            }

            result += getSubarrayCount(curr);
            curr = 0;
        }
        result += getSubarrayCount(curr);
        return result;
    }

    private long getSubarrayCount(long num) {
        return (1 + num) * (num) / 2;
    }
}
