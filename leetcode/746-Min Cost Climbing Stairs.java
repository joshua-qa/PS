/**
 * 2ms. 완전 기초 dp...
 */
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        int[] dp = new int[length];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < length; i++) {
            if (dp[i-2] + cost[i] < dp[i-1] + cost[i]) {
                dp[i] = dp[i-2] + cost[i];
            } else {
                dp[i] = dp[i-1] + cost[i];
            }
        }
        return dp[length-2] > dp[length-1] ? dp[length-1] : dp[length-2];
    }
}
