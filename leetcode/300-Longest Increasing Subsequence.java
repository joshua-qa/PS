// 93ms. O(n log n) 풀이로도 해봐야함.
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    dp[j] = (dp[i]+1) >= dp[j] ? dp[i]+1 : dp[j];
                }
            }
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result >= dp[i] ? result : dp[i];
        }
        return result;
    }
}
