// 9ms. 상당히 고생했는데 갑자기 깨달음 왔다. 재밌다. 비슷한 문제 많이 풀어봐야겠다
class Solution {
    private final long MOD = 1000000007;
    public int numRollsToTarget(int n, int k, int target) {
        long[][] dp = new long[target+1][n+1];
        if (n == 1) {
            return target <= k ? 1 : 0;
        }
        if (target < n) {
            return 0;
        }
        int init = target >= k ? k : target;
        for (int i = 1; i <= init; i++) {
            dp[i][1] = 1;
        }
        for (int i = 2; i <= n; i++) {
            int max = (i * k) > target ? target : i * k;
            for (int j = max; j >= i; j--) {
                int start = (j-k) >= 0 ? j-k : 0;
                for (int l = start; l < j; l++) {
                    dp[j][i] += dp[l][i-1];
                }
                dp[j][i] %= MOD;
            }
        }

        return (int) (dp[target][n] % MOD);
    }
}
