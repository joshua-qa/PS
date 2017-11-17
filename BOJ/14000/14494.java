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
        final int MOD = 1000000007;
        int n, m;
        long[][] D = new long[1001][1001];
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            m = in.nextInt();
            D[1][1] = 1;

            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= m; j++) {
                    D[i][j] += D[i-1][j-1] + D[i-1][j] + D[i][j-1];
                    D[i][j] %= MOD;
                }
            }

            out.print(D[n][m]);
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
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

    }
}