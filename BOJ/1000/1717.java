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
        private int n, m, curr, left, right;
        private int[] union;
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            m = in.nextInt();
            union = new int[n+1];
            for (int i = 1; i <= n; i++) {
                union[i] = i;
            }
            for (int i = 0; i < m; i++) {
                curr = in.nextInt();
                left = in.nextInt();
                right = in.nextInt();
                if (curr == 0) {
                    union(left, right);
                    continue;
                }
                if (find(left) == find(right)) {
                    out.write("YES\n");
                } else {
                    out.write("NO\n");
                }
            }
            out.flush();
        }

        private void union(int x, int y) {
            int xParent = find(x);
            int yParent = find(y);
            union[yParent] = xParent;
        }

        private int find(int x) {
            if (union[x] == x) {
                return x;
            }
            return union[x] = find(union[x]);
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
