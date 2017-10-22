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
        int c, n, lo, hi;
        int[] count = new int[10000001];
        StringBuilder sb = new StringBuilder();
        public void run(InputReader in, PrintWriter out) {
            c = in.nextInt();

            for(int i = 1; i <= 10000000; i++) {
                for(int j = 1; j <= 10000000 / i; j++) {
                    count[i * j]++;
                }
            }

            while(c-- > 0) {
                n = in.nextInt();
                lo = in.nextInt();
                hi = in.nextInt();

                sb.append(solve(n, lo, hi)).append("\n");
            }

            out.print(sb);
        }

        private int solve(int n, int lo, int hi) {
            int ans = 0;
            for(int i = lo; i <= hi; i++) {
                if(count[i] == n) {
                    ans++;
                }
            }

            return ans;
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