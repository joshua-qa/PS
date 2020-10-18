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
        private int[][][] dp;
        private int n, m, max, tree, sideTree;
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            m = in.nextInt();

            dp = new int[n+1][m+1][3];
            for (int i = 1; i <= n; i++) {
                tree = in.nextInt();

                sideTree = 3 - tree;
                dp[i][0][tree] = dp[i-1][0][tree];
                dp[i][0][sideTree] = dp[i-1][0][sideTree];
                if (tree == 1) {
                    dp[i][0][tree]++;
                }
                max = Math.max(Math.max(dp[i][0][tree], dp[i][0][sideTree]), max);
                for (int j = 1; j <= m && j <= i; j++) {
                    dp[i][j][tree] = Math.max(dp[i-1][j-1][sideTree], dp[i-1][j][tree]) + 1;
                    dp[i][j][sideTree] = Math.max(dp[i-1][j-1][tree], dp[i-1][j][sideTree]);
                    max = Math.max(Math.max(dp[i][j][tree], dp[i][j][sideTree]), max);
                }
            }
            out.print(max);
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
