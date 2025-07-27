class Solution {
    public int countHillValley(int[] nums) {
        int curr = 1, left = 0, right = 2, result = 0, size = nums.length;
        while (right < size) {
            while (right < size && nums[left] == nums[curr]) {
                curr++;
                right++;
            }

            while (right < size && nums[curr] == nums[right]) {
                right++;
            }

            if (right == size) {
                break;
            }
            left = curr-1;

            if ((nums[left] < nums[curr] && nums[right] < nums[curr]) || (nums[left] > nums[curr] && nums[right] > nums[curr])) {
                result++;
            }
            left = curr;
            curr = right;
            right++;
        }

        return result;
    }
}
