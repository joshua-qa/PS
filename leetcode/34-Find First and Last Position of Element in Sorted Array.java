/**
 * 0ms. 방법은 금방 떠올렸으나 여러모로 고생했다.. 덕분에 내가 lower_bound 개념을 잘못 이해하고 있었다는걸 깨달아서 이 문제가 제법 고맙다.
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int lower = lowerBound(nums, target);
        int upper = upperBound(nums, target);

        if (lower < 0 || lower >= nums.length || upper < 0) {
            return new int[]{-1, -1};
        }
        if (nums[lower] != target) {
            return new int[]{-1, -1};
        }
        if (upper >= nums.length || nums[upper] != target) {
            return new int[]{lower, upper-1};
        }
        return new int[]{lower, upper};
    }

    private int lowerBound(int[] nums, int target) {
        int start = 0;
        int end = nums.length;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private int upperBound(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;

        while (end > start) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                start = mid+1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
