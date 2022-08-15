// 2ms. 비추수가 엄청 많은 문제였다
class Solution {
    public int removeDuplicates(int[] nums) {
        int lastPos = 0, curr = 1, length = nums.length;
        while (curr < length) {
            while (curr < length && nums[lastPos] == nums[curr]) {
                curr++;
            }
            if (curr >= length) {
                return lastPos+1;
            }
            nums[lastPos+1] = nums[curr++];
            lastPos++;
        }
        return lastPos+1;
    }
}
