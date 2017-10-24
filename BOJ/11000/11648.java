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
        int n, ans;
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            char[] ca = String.valueOf(n).toCharArray();

            if(ca.length == 1) {
                out.print(0);
            } else {
                solve(ca, 1);
                out.print(ans);
            }
        }

        private void solve(char[] num, int count) {
            int curr = 1;
            for(int i : num) {
                curr *= (i - '0');
            }

            if(curr < 10) {
                ans = count;
                return;
            } else {
                solve(String.valueOf(curr).toCharArray(), count+1);
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

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}