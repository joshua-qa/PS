/**
 * 12ms. 정해보다는 느리지만..
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] nums : matrix) {
            if (nums[nums.length-1] < target) {
                continue;
            }
            if (Arrays.binarySearch(nums, target) >= 0) {
                return true;
            }
        }
        return false;
    }
}
