import java.util.*;
class Solution {
    int[] dx = {-1, 0, 0, 1};
    int[] dy = {0, -1, 1, 0};
    int[][] dp;
    boolean[][] visit;
    int size;
    public int solution(int[][] board) {
        size = board[0].length;
        dp = new int[size][size];
        visit = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        dfs(0, 0, -1, board);

        return dp[size-1][size-1];
    }

    private void dfs(int x, int y, int prevDir, int[][] board) {
        if (x == size - 1 && y == size - 1) {
            return;
        }
        for (int i = 0; i < dx.length; i++) {
            int currX = x + dx[i];
            int currY = y + dy[i];
            if (!isMovable(currX, currY, board) || visit[currX][currY]) {
                continue;
            }

            int pay = calculatePay(prevDir, i);
            if (dp[currX][currY] < dp[x][y] + pay) {
                continue;
            }
            dp[currX][currY] = dp[x][y] + pay;
            visit[currX][currY] = true;
            dfs(currX, currY, i, board);
            visit[currX][currY] = false;
        }
    }

    private boolean isMovable(int x, int y, int[][] board) {
        return x >= 0 && x < size && y >= 0 && y < size && board[x][y] == 0;
    }

    private int calculatePay(int prevDir, int currentDir) {
        if (prevDir == -1) {
            return 100;
        }
        if ((prevDir == 0 || prevDir == 3) && (currentDir == 1 || currentDir == 2)) {
            return 600;
        }
        if ((prevDir == 1 || prevDir == 2) && (currentDir == 0 || currentDir == 3)) {
            return 600;
        }
        return 100;
    }
}