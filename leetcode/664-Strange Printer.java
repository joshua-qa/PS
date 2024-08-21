class Solution {
    public int strangePrinter(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;

        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        int j = 0;
        for (int l = 2; l <= n; l++) {
            for (int i = 0; i < n - l + 1; i++) {
                j = i + l - 1;
                dp[i][j] = dp[i][j-1] + 1;
                for (int k = i; k < j; k++) {
                    if (chars[k] == chars[j]) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j-1]);
                    } else {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j]);
                    }
                }
            }
        }
        return dp[0][n-1];
    }
}
