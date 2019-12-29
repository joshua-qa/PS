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
        int n, m, s, e;
        int[] nums;
        int[][] dp;
        StringBuilder sb = new StringBuilder();
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            nums = new int[n+1];
            dp = new int[n+1][n+1];
            for (int i = 1; i <= n; i++) {
                nums[i] = in.nextInt();
                dp[i][i] = 1;
            }
            init();
            m = in.nextInt();
            for (int i = 0; i < m; i++) {
                s = in.nextInt();
                e = in.nextInt();
                sb.append(dp[s][e]).append("\n");
            }
            out.print(sb);
        }

        private void init() {
            for (int i = 1; i < n; i++) {
                int start = i - 1, end = i + 1;
                while (start > 0 && end <= n && nums[start] == nums[end]) {
                    dp[start--][end++] = 1;
                }
                if (nums[i] == nums[i+1]) {
                    dp[i][i+1] = 1;
                    start = i - 1;
                    end = i + 2;
                    while (start > 0 && end <= n && nums[start] == nums[end]) {
                        dp[start--][end++] = 1;
                    }
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
