/**
 * 0ms
 */
class Solution {
    int[] dp;
    public int fib(int n) {
        dp = new int[n+1];
        return fibo(n);
    }

    private int fibo(int n) {
        if (n <= 1) {
            return n;
        }
        if (n == 2) {
            return 1;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] = fibo(n-1) + fibo(n-2);
        return dp[n];
    }
}
