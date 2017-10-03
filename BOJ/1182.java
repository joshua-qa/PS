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
        int n, s, ans;
        int[] nums;
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            s = in.nextInt();
            nums = new int[n];

            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }

            for (int i = 1; i <= n; i++) {
                for(int j = 0; j <= n-i; j++) {
                    solve(i, j, 0);
                }
            }

            out.print(ans);
        }

        private void solve(int count, int pos, int curr) {
            if(count == 1) {
                curr += nums[pos];
                if(curr == s) {
                    ans++;
                }
                return;
            }

            curr += nums[pos];
            for(int i = pos+1; i <= n-count+1; i++) {
                solve(count-1, i, curr);
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