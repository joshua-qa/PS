/**
 * Arrays.sort 써서 풀면 3줄이면 되고, 이거보다 빠르다. PQ 써서 풀어도 몇줄 안나옴.
 * Quick Selection 연습했으니 만족
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int length = nums.length;
        int result = quickSelection(nums, 0, length-1, k);
        return nums[result];
    }

    private int quickSelection(int[] nums, int start, int end, int k) {
        if (start == end) {
            return start;
        }

        int i = start;
        int pivot = end;
        for (int j = start; j < end; j++) {
            if (nums[j] <= nums[pivot]) {
                swap(nums, i, j);
                i++;
            }
        }

        swap(nums, i, pivot);
        // case 1 ( < )
        if (end - i + 1 < k) {
            return quickSelection(nums, start, i-1, k - (end-i+1));
        }
        // case 2 ( >= )
        return quickSelection(nums, i, end, k);
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
