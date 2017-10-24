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
        int n, m, currA, currB, a, b, gcd;
        long mul;
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            m = in.nextInt();

            mul = (long)n * (long)m;

            for(long i = n; i * i <= mul; i += n) {
                if(mul % i != 0) {
                    continue;
                }
                currA = (int)i;
                currB = (int)(mul/i);
                gcd = gcd(currA, currB);
                if(gcd != n || mul / (long)gcd != m) {
                    continue;
                } else if(a+b == 0 || a+b > currA+currB) {
                    a = currA;
                    b = currB;
                }
            }

            out.print(a + " " + b);
        }
        private int gcd(int p, int q) {
            if (q == 0) {
                return p;
            }
            return gcd(q, p%q);
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