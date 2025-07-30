class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0, size = nums.length;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }

        int result = 0, curr = 0;
        for (int i = 0; i < size; i++) {
            if (nums[i] == max) {
                curr++;
            } else {
                result = Math.max(result, curr);
                curr = 0;
            }
        }
        return Math.max(result, curr);
    }
}
