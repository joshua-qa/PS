// 18ms. 풀어볼 가치가 있는 문제다. 재밌었다.
class Solution {
    public int countVowelPermutation(int n) {
        long[] dp = new long[5];
        long[] temp = new long[5];
        long mod = 1000000007;
        Arrays.fill(dp, 1);
        for (int i = 2; i <= n; i++) {
            temp[0] = (dp[1] + dp[2] + dp[4]) % mod;
            temp[1] = (dp[0] + dp[2]) % mod;
            temp[2] = (dp[1] + dp[3]) % mod;
            temp[3] = dp[2] % mod;
            temp[4] = (dp[2] + dp[3]) % mod;
            for (int j = 0; j <= 4; j++) {
                dp[j] = temp[j];
            }
        }
        return (int) ((dp[0] + dp[1] + dp[2] + dp[3] + dp[4]) % mod);
   }
}
