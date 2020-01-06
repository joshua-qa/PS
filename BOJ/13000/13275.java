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
        private int result, length;
        private int[] dp;
        private char[] string;
        public void run(InputReader in, PrintWriter out) {
            char[] input = in.next().toCharArray();
            init(input);
            process();

            out.print(result);
        }

        private void init(char[] input) {
            string = new char[input.length * 2 + 1];
            dp = new int[string.length];
            for (int i = 0, j = 0; i < string.length; i++) {
                if ((i & 1) == 0) {
                    string[i] = '#';
                    continue;
                }
                string[i] = input[j++];
            }
        }

        private void process() {
            int p = 0, r = 0;
            length = string.length;

            for (int i = 0; i < length; i++) {
                if (r >= i) {
                    dp[i] = Math.min(dp[2 * p - i], r - i);
                }
                while (i - dp[i] - 1 >= 0 && i + dp[i] + 1 < length && string[i - dp[i] - 1] == string[i + dp[i] + 1]) {
                    dp[i]++;
                }
                if (i + dp[i] > r) {
                    r = i + dp[i];
                    p = i;
                }
                if (result < dp[i]) {
                    result = dp[i];
                }
            }
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
