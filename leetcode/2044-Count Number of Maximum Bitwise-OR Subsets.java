class Solution {
    private int count, max, size;
    public int countMaxOrSubsets(int[] nums) {
        // backtracking
        size = nums.length;
        if (size == 1) {
            return 1;
        }
        for (int num : nums) {
            max |= num;
        }

        for (int i = 0; i < size; i++) {
            rec(nums, 0, i);
        }
        return count;
    }

    private void rec(int[] nums, int currValue, int currIndex) {
        int result = currValue | nums[currIndex];
        if (result == max) {
            count++;
        }
        if (currIndex == size-1) {
            return;
        }
        for (int i = currIndex+1; i < size; i++) {
            rec(nums, result, i);
        }
    }
}
