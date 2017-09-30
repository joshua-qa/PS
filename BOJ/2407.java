import java.io.*;
import java.math.BigInteger;
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
        public void run(InputReader in, PrintWriter out) {
            BigInteger ans = BigInteger.ONE;
            BigInteger mod1 = BigInteger.ONE;
            BigInteger mod2 = BigInteger.ONE;

            int n = in.nextInt();
            int m = in.nextInt();
            int k = n - m;

            for(int i = 2; i <= n; i++) {
                ans = ans.multiply(BigInteger.valueOf(i));
            }

            for(int i = 2; i <= m; i++) {
                mod1 = mod1.multiply(BigInteger.valueOf(i));
            }

            for(int i = 2; i <= k; i++) {
                mod2 = mod2.multiply(BigInteger.valueOf(i));
            }

            ans = ans.divide(mod1);
            ans = ans.divide(mod2);

            out.print(ans);
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