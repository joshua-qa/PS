// 깔끔하게 그리디로 0ms...
class Solution {
    public int wiggleMaxLength(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return length;
        }

        int result = 1;
        int i = 1;
        boolean flag = nums[i] - nums[i-1] > 0;
        while (i < length) {
            boolean isZero = nums[i] - nums[i-1] == 0;
            if (flag) {
                while (i != length && nums[i] - nums[i-1] >= 0) {
                    i++;
                }
                result++;
                flag = false;
            } else if (isZero) {
                while (i != length && nums[i] - nums[i-1] == 0) {
                    i++;
                }
                if (i == length) {
                    break;
                }
                flag = nums[i] - nums[i-1] > 0;
            } else {
                while (i != length && nums[i] - nums[i-1] <= 0) {
                    i++;
                }
                result++;
                flag = true;
            }
        }
        return result;
    }
}
