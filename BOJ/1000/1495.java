import java.io.*;
import java.util.StringTokenizer;

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
        int n, s, m, result = -1;
        int[] v;
        boolean[][] dp = new boolean[101][1001];
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            s = in.nextInt();
            m = in.nextInt();
            v = new int[n+1];

            for(int i = 1; i <= n; i++) {
                v[i] = in.nextInt();
            }

            dp[0][s] = true;

            for(int i = 0; i < n; i++) {
                for(int j = 0; j <= m; j++) {
                    if(dp[i][j]) {
                        if (j - v[i+1] >= 0 && !dp[i+1][j - v[i+1]]) {
                            dp[i+1][j - v[i+1]] = true;
                        }

                        if (j + v[i+1] <= m && !dp[i+1][j + v[i+1]]) {
                            dp[i+1][j + v[i+1]] = true;
                        }
                    }
                }
            }

            for(int i = m; i >= 0 && result < 0; i--) {
                if(dp[n][i]) {
                    result = i;
                }
            }

            out.print(result);
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