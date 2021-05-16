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
        private int n, m, v, c, k, totalCount, result;
        private int[] dp;
        private int[][] objects;
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            m = in.nextInt();
            dp = new int[m+1];
            objects = new int[n*14][2];
            for (int i = 0; i < n; i++) {
                v = in.nextInt();
                c = in.nextInt();
                k = in.nextInt();

                for (int pow = 1; k > 0; pow <<= 1) {
                    int min = Math.min(pow, k);
                    objects[totalCount][0] = v * min;
                    objects[totalCount][1] = min * c;
                    totalCount++;
                    k -= min;
                }
            }

            for (int j = 0; j < totalCount; j++) {
                for (int i = m; i >= 0; i--) {
                    int weight = objects[j][0];
                    int prevWeight = i - weight;
                    if (prevWeight < 0) {
                        break;
                    }
                    if (dp[prevWeight] + objects[j][1] > dp[i]) {
                        dp[i] = dp[prevWeight] + objects[j][1];
                    }
                }
            }

            for (int i = 0; i <= m; i++) {
                if (result < dp[i]) {
                    result = dp[i];
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
