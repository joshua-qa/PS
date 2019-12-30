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
        int n, m, currentWeight, currentValue;
        int[][] dp = new int[101][100001];
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            m = in.nextInt();

            for (int i = 1; i <= n; i++) {
                currentWeight = in.nextInt();
                currentValue = in.nextInt();
                for (int j = 0; j <= m; j++) {
                    dp[i][j] = dp[i-1][j];
                    if (j >= currentWeight && dp[i][j] < dp[i-1][j-currentWeight] + currentValue) {
                        dp[i][j] = dp[i-1][j-currentWeight] + currentValue;
                    }
                }
            }
            out.print(dp[n][m]);
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
