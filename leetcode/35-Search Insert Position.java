// 0ms. 21년 12월에 이걸 풀었던 기록이 있는데 그 때보다 코드가 깔끔해졌다.
class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        if (target > nums[end]) {
            return nums.length;
        }

        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] > target) {
                end = mid;
            } else if (nums[mid] == target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
