// 1ms. 수열의 규칙을 찾아서 풀었다. 사람들 풀이 보니까 신기한 풀이 많더라.
class Solution {
    public int numTilings(int n) {
        long[] dp = new long[1001];
        long mod = 1000000007;

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i-1] * 2 + dp[i-3];
            dp[i] %= mod;
        }
        return (int) dp[n];
    }
}
