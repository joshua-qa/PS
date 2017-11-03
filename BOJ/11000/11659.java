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
        int n, m, x, y;
        int[] elements;
        long[] tree;
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            m = in.nextInt();
            elements = new int[n+1];
            tree = new long[n+1];

            for(int i = 1; i <= n; i++) {
                elements[i] = in.nextInt();
                update(i, elements[i]);
            }

            while(m-- > 0) {
                x = in.nextInt();
                y = in.nextInt();
                out.println(sum(y) - sum(x-1));
            }
        }

        private void update(int i, long diff) {
            while(i < tree.length) {
                tree[i] += diff;
                i += (i & -i);
            }
        }

        private long sum(int i) {
            long ans = 0;

            while(i > 0) {
                ans += tree[i];
                i -= (i & -i);
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

    }
}