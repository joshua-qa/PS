class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0, prev = 0, curr = 0, length = nums.length;

        int i = 0;
        while (i < length) {
            if (nums[i] == 0) {
                prev = curr;
                curr = 0;
            }
            if (i > 0 && nums[i] == 0 && nums[i-1] == 0) {
                prev = 0;
            }
            if (nums[i] == 1) {
                curr++;
                if (prev + curr > max) {
                    max = prev + curr;
                }
            }
            i++;
        }

        return max == length ? length-1 : max;
    }
}
