// 0ms. Binary Search 연습하기 좋은 문제
class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int start = 0;
        int end = nums.length-1;

        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]) {
                return nums[mid];
            }
            int leftSize = (nums[mid] == nums[mid-1]) ? Math.max(0, (mid-1) - start) : (mid) - start;
            int rightSize = (nums[mid] == nums[mid-1]) ? end - (mid) : Math.max(0, end - (mid+1));

            if ((leftSize & 1) == 1) {
                end = start + leftSize - 1;
            } else {
                start = end - rightSize + 1;
            }
        }
        return nums[start];
    }
}
