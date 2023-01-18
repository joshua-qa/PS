// 5ms. 여러 의미로 환상적인 미디엄 문제다. prefix sum도 알아야 하고, kadane algorithm도 알아야 한다.
// 공식 솔루션 중 두번째 것도 공부해둘만 하다.
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int length = nums.length;
        int[] prefixSum = new int[length];
        int[] suffixSum = new int[length];
        prefixSum[0] = nums[0];
        suffixSum[length-1] = nums[length-1];
        for (int i = 1; i < length; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
            suffixSum[length-i-1] = suffixSum[length-i] + nums[length-i-1];
        }

        for (int i = 1; i < length; i++) {
            prefixSum[i] = Math.max(prefixSum[i-1], prefixSum[i]);
            suffixSum[length-i-1] = Math.max(suffixSum[length-i], suffixSum[length-i-1]);
        }
        int max = nums[0];
        int[] maxs = new int[length];
        maxs[0] = nums[0];
        int anotherMax = Integer.MIN_VALUE;
        for (int i = 1; i < length; i++) {
            maxs[i] = Math.max(maxs[i-1] + nums[i], nums[i]);
            max = Math.max(max, maxs[i]);
        }
        for (int i = 0; i < length-1; i++) {
            anotherMax = Math.max(anotherMax, prefixSum[i] + suffixSum[i + 1]);
        }
        return Math.max(max, anotherMax);
    }
}
