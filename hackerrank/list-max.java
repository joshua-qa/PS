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
        final int MAX = (int)1e7;
        int n, m, x, y;
        long query, ans;
        long[] nums = new long[MAX + 2];

        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            m = in.nextInt();

            for(int i = 0; i < m; i++) {
                x = in.nextInt();
                y = in.nextInt();
                query = in.nextLong();

                nums[x] += query;
                nums[y+1] -= query;
            }

            for(int i = 1; i <= n; i++) {
                nums[i] += nums[i-1];
                if(nums[i] > ans) {
                    ans = nums[i];
                }
            }

            out.println(ans);
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