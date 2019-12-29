import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    int n, m;
    int[] dirX = {-1, -1, -1, 0, 0, 1, 1, 1};
    int[] dirY = {-1, 0, 1, -1, 1, -1, 0, 1};
    int[][][] dp;
    char[][] board = new char[5][5];
    private void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                board[j] = br.readLine().toCharArray();
                dp = new int[5][5][10];
            }

            m = Integer.parseInt(br.readLine());
            for (int k = 0; k < m; k++) {
                String input = br.readLine();
                sb.append(input + " " + (solve(input) ? "YES\n" : "NO\n"));
                reset();
            }
        }
        System.out.print(sb);
    }

    private void reset() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Arrays.fill(dp[i][j], 0);
            }
        }
    }

    private boolean solve(String input) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (dfs(i, j, 0, input.toCharArray()) == 2) {
                    return true;
                }
            }
        }
        return false;
    }

    private int dfs(int x, int y, int index, char[] input) {
        if (index == input.length - 1) {
            dp[x][y][index] = (board[x][y] == input[index]) ? 2 : 1;
            return dp[x][y][index];
        }
        if (dp[x][y][index] != 0) {
            return dp[x][y][index];
        }
        if (input[index] != board[x][y]) {
            dp[x][y][index] = 1;
            return dp[x][y][index];
        }
        for (int i = 0; i < 8; i++) {
            int currX = x + dirX[i];
            int currY = y + dirY[i];
            if (currX < 0 || currX >= 5 || currY < 0 || currY >= 5) {
                continue;
            }
            dp[x][y][index] = Math.max(dp[x][y][index], dfs(currX, currY, index+1, input));
        }
        return dp[x][y][index];
    }
}