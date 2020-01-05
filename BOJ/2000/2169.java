import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task task = new Task();
        task.run(in, out);
        out.close();
    }

    static class Task {
        public static final int MIN = -1000000;
        public static final int[] DIR_X = {0, 1, 0};
        public static final int[] DIR_Y = {-1, 0, 1};
        private int n, m;
        private int[][] map;
        private int[][][] dp;
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            m = in.nextInt();

            map = new int[n][m];
            dp = new int[n][m][3];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    map[i][j] = in.nextInt();
                    dp[i][j][0] = dp[i][j][1] = dp[i][j][2] = MIN;
                }
            }

            if (n == 1 && m == 1) {
                out.print(map[0][0]);
                return;
            }
            boolean[][] visit = new boolean[n][m];
            visit[0][0] = true;
            dfs(0, 0, visit);
            out.print(max(dp[0][0][1], dp[0][0][2]));
        }

        private int dfs(int x, int y, boolean[][] visit) {
            if (x == n-1 && y == m-1) {
                return map[x][y];
            }

            int currentValue = MIN * 2;
            for (int i = 0; i < 3; i++) {
                int currX = x + DIR_X[i];
                int currY = y + DIR_Y[i];
                if (currX < 0 || currX >= n || currY < 0 || currY >= m || visit[currX][currY] || (x == n-1 && i == 0)) {
                    continue;
                }
                if (dp[x][y][i] != MIN) {
                    currentValue = max(currentValue, dp[x][y][i]);
                    continue;
                }
                visit[currX][currY] = true;
                dp[x][y][i] = max(dp[x][y][i], map[x][y] + dfs(currX, currY, visit));
                currentValue = max(currentValue, dp[x][y][i]);
                visit[currX][currY] = false;
            }
            return currentValue;
        }

        private int max(int x, int y) {
            return x >= y ? x : y;
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
