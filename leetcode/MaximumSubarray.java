public class Solution {

    public static void main(String[] args) {
      new Solution().run();
    }

    private void run() {
        int[] example = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] example2 = {-1, -2, -3, -4, -5};
        int[] example3 = {-2, -1};
        System.out.println(maxSubArray(example));
        System.out.println(maxSubArray(example2));
        System.out.println(maxSubArray(example3));
    }

    public int maxSubArray(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] + nums[i] > nums[i]) {
                nums[i] += nums[i-1];
            }
            if (result < nums[i]) {
                result = nums[i];
            }
        }

        return result;
    }
}
