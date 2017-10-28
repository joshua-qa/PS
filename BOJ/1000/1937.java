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
        int n, ans;
        int[] dX = {-1, 0, 0, 1};
        int[] dY = {0, -1, 1, 0};
        int[][] map, D;
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            map = new int[n][n];
            D = new int[n][n];

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    map[i][j] = in.nextInt();
                }
            }

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(D[i][j] < 2) {
                        D[i][j] = 1;
                        dfs(i, j, 1);
                    }
                }
            }

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(D[i][j] > ans) {
                        ans = D[i][j];
                    }
                }
            }
            out.print(ans);
        }

        private void dfs(int x, int y, int move) {
            for(int i = 0; i < dX.length; i++) {
                if(x + dX[i] < 0 || x + dX[i] >= n || y + dY[i] < 0 || y + dY[i] >= n) {
                    continue;
                }
                if(map[x + dX[i]][y + dY[i]] > map[x][y] && D[x][y] + 1 > D[x + dX[i]][y + dY[i]]) {
                    D[x + dX[i]][y + dY[i]] = D[x][y] + 1;
                    dfs(x + dX[i], y + dY[i], move + 1);
                }
            }
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

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}