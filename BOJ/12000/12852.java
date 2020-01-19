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
        int n, max = 987654321;
        int[] dp, beforeStep;
        Stack<Integer> stack = new Stack<>();
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            dp = new int[n+1];
            init();
            beforeStep = new int[n+1];
            for (int i = 1; i < n; i++) {
                int d = i + i;
                int t = d + i;
                if (t <= n && dp[t] > dp[i] + 1) {
                    dp[t] = dp[i] + 1;
                    beforeStep[t] = i;
                }
                if (d <= n && dp[d] > dp[i] + 1) {
                    dp[d] = dp[i] + 1;
                    beforeStep[d] = i;
                }
                if (dp[i+1] > dp[i] + 1) {
                    dp[i+1] = dp[i] + 1;
                    beforeStep[i+1] = i;
                }
            }
            out.write(dp[n] + "\n");
            while(n > 0) {
                out.write(n + " ");
                n = beforeStep[n];
            }
            out.flush();
        }
        private void init() {
            for (int i = 2; i <= n; i++) {
                dp[i] = max;
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
