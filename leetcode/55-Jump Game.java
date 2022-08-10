// 1ms. 네번이나 틀리고 맞을 난이도는 아닌데 너무 날먹하려고 했다...
class Solution {
    public boolean canJump(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return true;
        }
        if (nums[0] == 0) {
            return false;
        }
        int curr = 0;
        while (curr >= 0 && curr < length-1) {
            if (nums[curr] == 0) {
                int prev = curr-1;
                while (prev > 0 && nums[prev] + prev <= curr) {
                    prev--;
                }
                if (prev <= 0) {
                    return false;
                }
                curr = nums[prev] + prev;
                continue;
            }
            curr += nums[curr];
        }
        return curr >= length-1;
    }
}
