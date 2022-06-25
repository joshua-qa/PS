/**
 * 1ms.. 미디엄이라면 미디엄일 수 있는데 각 케이스들만 잘 고려해주면 풀리는듯
 */
class Solution {
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        int length = nums.length;
        if (length <= 2) {
            return true;
        }
        for (int i = 0; i < length-1; i++) {
            if (nums[i] <= nums[i+1]) {
                continue;
            }
            if (i + 2 == length || nums[i] <= nums[i+2]) {
                nums[i+1] = nums[i];
                count++;
            } else if(i-1 >= 0 && nums[i-1] > nums[i+1]) {
                nums[i+1] = nums[i];
                count++;
            } else {
                nums[i] = nums[i+1];
                count++;
            }
            if (count == 2) {
                return false;
            }
        }
        return count < 2;
    }
}