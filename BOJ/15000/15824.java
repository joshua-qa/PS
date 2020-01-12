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
        public static final long MOD = 1000000007;
        private int n;
        private long result;
        private long[] nums, pow;
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();

            nums = new long[n];
            pow = new long[n+1];
            pow[0] = 1;
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextLong();
                pow[i+1] = (pow[i] * 2) % MOD;
            }

            Arrays.sort(nums);

            for (int i = 0; i < n; i++) {
                long low = pow[i];
                long hi = pow[n-i-1];
                long curr = ((low - hi) % MOD) * (nums[i] % MOD);
                curr %= MOD;
                result += curr;
                result %= MOD;
            }
            out.write((result + MOD) % MOD + "\n");

            out.flush();
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
