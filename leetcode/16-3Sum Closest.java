// 2720ms. 통과는 했는데 다시 풀어야함
class Solution {
    private int MAX = 987654321;
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int length = nums.length;
        int result = MAX;
        int resultAbs = abs(result - target);
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length && j+1 != length; j++) {
                int currSum = nums[i] + nums[j];
                int thirdNum = target - currSum;
                int lowerBound = lowerBound(j+1, length-1, thirdNum, nums);
                int upperBound = upperBound(j+1, length-1, thirdNum, nums);

                int absNum = 0;

                if (isRange(lowerBound, length)) {
                    lowerBound = nums[lowerBound];
                }
                if (isRange(upperBound, length)) {
                    upperBound = nums[upperBound];
                }
                if (abs(thirdNum - lowerBound) < abs(thirdNum - upperBound)) {
                    absNum = lowerBound + currSum;
                } else {
                    absNum = upperBound + currSum;
                }
                if (abs(absNum - target) < resultAbs) {
                    result = absNum;
                    resultAbs = abs(absNum - target);
                }
            }
        }
        return result;
    }

    private boolean isRange(int index, int length) {
        return index >= 0 && index < length;
    }

    private int lowerBound(int start, int end, int target, int[] nums) {
        int mid = start;
        while (start < end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return nums[mid] > target ? MAX : mid;
    }

    private int upperBound(int start, int end, int target, int[] nums) {
        int mid = start;
        while (start < end) {
            mid = (start + end) / 2;
            if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid+1;
            }
        }
        return nums[mid] < target ? MAX : mid;
    }

    private int abs(int num) {
        return  (num < 0) ? -num : num;
    }
}
