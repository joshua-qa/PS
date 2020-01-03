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
        public static final int MAX = 1000000000;
        int n, fullVisit;
        int[][] cities;
        int[][] dp;
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            fullVisit = (1 << n) - 1;
            cities = new int[n][n];
            dp = new int[fullVisit + 1][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    cities[i][j] = in.nextInt();
                }
            }
            for (int i = 0; i <= fullVisit; i++) {
                Arrays.fill(dp[i], MAX);
            }
            dp[1][0] = 0;
            for (int i = 1; i < fullVisit; i += 2) {
                for (int j = 1; j < n; j++) {
                    int currentBit = 1 << j;
                    if ((i & currentBit) != 0) {
                        continue;
                    }
                    int current = i | currentBit;

                    for (int k = 0; k < n; k++) {
                        if ((dp[i][k] == MAX) || (i & (1 << k)) == 0) {
                            continue;
                        }
                        if (cities[k][j] == 0) {
                            continue;
                        }
                        dp[current][j] = Math.min(dp[current][j], dp[i][k] + cities[k][j]);
                    }
                }
            }
            for (int i = 1; i < n; i++) {
                if (cities[i][0] != 0) {
                    dp[fullVisit][0] = Math.min(dp[fullVisit][0], dp[fullVisit][i] + cities[i][0]);
                }
            }
            out.print(dp[fullVisit][0]);
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
