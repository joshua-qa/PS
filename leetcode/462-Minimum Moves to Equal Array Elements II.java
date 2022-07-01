class Solution {
    public int minMoves2(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        int result = 0;
        int mid = length / 2;
        for (int num : nums) {
            result += Math.abs(num - nums[mid]);
        }

        return result;
    }
}