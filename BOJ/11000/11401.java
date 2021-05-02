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
        private long n, m, k, nFac = 1, mFac = 1, kFac = 1;
        private static final long MOD = 1000000007;
        public void run(InputReader in, PrintWriter out) {
            n = in.nextLong();
            m = in.nextLong();

            k = n - m;

            for (long i = 2; i <= n; i++) {
                nFac *= i;
                nFac %= MOD;
            }

            for (long i = 2; i <= m; i++) {
                mFac *= i;
                mFac %= MOD;
            }

            for (long i = 2; i <= k; i++) {
                kFac *= i;
                kFac %= MOD;
            }

            long inverse = (mFac * kFac) % MOD;
            inverse = pow(inverse, MOD - 2);
            inverse = (nFac * inverse) % MOD;

            out.print(inverse);
        }

        private long pow(long num, long p) {
            if (p == 1) {
                return num;
            }
            long result = pow(num, p / 2);
            if (p % 2 == 1) {
                return (((result * result) % MOD) * num) % MOD;
            }
            return (result * result) % MOD;
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
