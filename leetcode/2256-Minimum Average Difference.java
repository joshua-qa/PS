// 17ms. 간만에 미디엄 수준에 딱 맞는 문제를 데일리에서 볼 수 있었다.
// 이런 문제는 오버플로우 이슈를 항상 조심해야한다.
class Solution {
    public int minimumAverageDifference(int[] nums) {
        int length = nums.length;
        long[] prefixSum = new long[length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < length; i++) {
            prefixSum[i] = prefixSum[i-1] + (long) nums[i];
        }

        int result = Integer.MAX_VALUE;
        int resultIndex = 0;
        for (int i = 0; i < length; i++) {
            long leftSize = i+1;
            long rightSize = length - leftSize;
            long leftAverage = prefixSum[i] / leftSize;
            long rightAverage = (i == length-1) ? 0 : (prefixSum[length-1] - prefixSum[i]) / rightSize;
            long currAbs = Math.abs(leftAverage - rightAverage);
            if (result > currAbs) {
                result = (int) currAbs;
                resultIndex = i;
            }
        }
        return resultIndex;
    }
}
