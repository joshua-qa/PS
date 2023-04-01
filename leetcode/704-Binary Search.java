// 0ms. 평범한 연습용 문제
class Solution {
    public int search(int[] nums, int target) {
        int start = 0, length = nums.length, end = length-1;
        if (length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] > target) {
                end = mid-1;
            } else if (nums[mid] < target) {
                start = mid+1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
