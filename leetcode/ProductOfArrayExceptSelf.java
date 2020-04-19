import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
      new Solution().run();
    }

    private void run() {
        int[] example = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(example)));
    }

    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] prefix = new int[length];
        int[] suffix = new int[length];
        prefix[0] = 1;
        suffix[length-1] = 1;
        for (int i = 1; i < length; i++) {
            prefix[i] = prefix[i-1] * nums[i-1];
        }
        for (int i = length-2; i >= 0; i--) {
            suffix[i] = suffix[i+1] * nums[i+1];
        }
        for (int i = 0; i < length; i++) {
            nums[i] = prefix[i] * suffix[i];
        }
        return nums;
    }
}
