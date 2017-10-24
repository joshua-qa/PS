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
        int n, m;
        StringBuilder sb = new StringBuilder();
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            while(n-- > 0) {
                long currGcd = 0;
                m = in.nextInt();
                long[] nums = new long[m];

                for(int i = 0; i < m; i++) {
                    nums[i] = in.nextLong();
                }

                for(int i = 0; i < m-1; i++) {
                    for(int j = i+1; j < m; j++) {
                        currGcd += gcd(nums[i], nums[j]);
                    }
                }

                sb.append(currGcd).append("\n");
            }

            out.print(sb);
        }

        private long gcd(long p, long q) {
            if(q == 0) {
                return p;
            }
            return gcd(q, p % q);
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