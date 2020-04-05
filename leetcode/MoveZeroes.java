public class Solution {

    public static void main(String[] args) {
      new Solution().run();
    }

    private void run() {
        int[] example = {0, 1, 0, 3, 12};
        int[] example2 = {1, 2, 3, 0, 0};
        int[] example3 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100, 0};
        moveZeroes(example);
        moveZeroes(example2);
        moveZeroes(example3);
    }

    public void moveZeroes(int[] nums) {
        int left = 0, right = 0, temp = 0, length = nums.length;
        while (left < length - 1 || right < length - 1) {
            if (left == right) {
                right++;
                continue;
            }
            if (nums[left] == 0 && nums[right] != 0) {
                temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            if (nums[left] != 0 || nums[left] == 0 && right == length - 1) {
                left++;
                continue;
            }
            if (right < length - 1) {
                right++;
            }
        }
    }
}
