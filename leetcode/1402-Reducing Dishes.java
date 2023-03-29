// 7ms. 그냥 DP로 풀었는데 그리디도 있었다.
class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int length = satisfaction.length;
        int[][] dp = new int[length][length];
        int result = 0;
        dp[0][0] = satisfaction[0];
        for (int i = 1; i < length; i++) {
            dp[i][0] = satisfaction[i];
            if (result < dp[i][0]) {
                result = dp[i][0];
            }
            for (int j = 1; j <= i; j++) {
                dp[i][j] = dp[i-1][j-1] + (satisfaction[i] * (j+1));
                if (result < dp[i][j]) {
                    result = dp[i][j];
                }
            }
        }
        return result;
    }
}
