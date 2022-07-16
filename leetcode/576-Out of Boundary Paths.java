/**
 * 11ms. dfs dp 재밌어졌다.
 */
class Solution {
    int width, height;
    long mod = 1000000007;
    long[][][] dp;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        width = m;
        height = n;
        dp = new long[m][n][maxMove+1];
        return (int) (dfs(startRow, startColumn, maxMove) % mod);
    }

    private long dfs(int currX, int currY, int remainMove) {
        if (currX < 0 || currX >= width || currY < 0 || currY >= height) {
            return 1;
        }
        if (!isAvailable(currX, currY, remainMove-1)) {
            return 0;
        }
        if (dp[currX][currY][remainMove] != 0) {
            return dp[currX][currY][remainMove] % mod;
        }

        dp[currX][currY][remainMove] =
                dfs(currX-1, currY, remainMove-1) + dfs(currX, currY-1, remainMove-1) +
                        dfs(currX+1, currY, remainMove-1) + dfs(currX, currY+1, remainMove-1);
        return dp[currX][currY][remainMove] % mod;
    }

    private boolean isAvailable(int currX, int currY, int remainMove) {
        return currX <= remainMove || width-currX <= remainMove+1 || currY <= remainMove || height-currY <= remainMove+1;
    }
}
