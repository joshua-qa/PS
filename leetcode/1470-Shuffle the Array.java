// 0ms. 완전 쉬움
class Solution {
    public int[] shuffle(int[] nums, int n) {
        int length = n * 2;
        int[] result = new int[length];
        for (int i = 0; n < length; i++, n++) {
            result[i*2] = nums[i];
            result[i*2+1] = nums[n];
        }
        return result;
    }
}
