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
        int n, m, query, currUnion;
        boolean isUnion = true;
        int[][] map;
        int[] union;
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            m = in.nextInt();

            map = new int[n][n];
            union = new int[n];
            for (int i = 0; i < n; i++) {
                union[i] = i;
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = in.nextInt();
                    if (map[i][j] == 1) {
                        union(i, j);
                    }
                }
            }

            query = in.nextInt() - 1;
            currUnion = find(query);
            for (int i = 1; i < m; i++) {
                query = in.nextInt() - 1;
                if (find(query) != currUnion) {
                    isUnion = false;
                    break;
                }
            }
            out.print(isUnion ? "YES" : "NO");
        }

        private void union(int x, int y) {
            int left = find(x);
            int right = find(y);
            if (left == right) {
                return;
            }
            union[right] = left;
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
