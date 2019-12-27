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
        int n, q, rIndex;
        int[] parent, union;
        boolean[] result;
        Stack<String> queries = new Stack<>();
        StringBuilder sb = new StringBuilder();
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            q = in.nextInt();

            parent = new int[n+1];
            union = new int[n+1];
            result = new boolean[q];
            parent[1] = 1;
            for (int i = 2; i <= n; i++) {
                parent[i] = in.nextInt();
            }
            for (int i = 0; i < n+q-1; i++) {
                queries.push(in.nextLine());
            }
            init();
            while (!queries.isEmpty()) {
                StringTokenizer st = new StringTokenizer(queries.pop(), " ");
                int queryType = Integer.parseInt(st.nextToken());
                int currNode = Integer.parseInt(st.nextToken());
                if (queryType == 0) {
                    union(currNode, parent[currNode]);
                    continue;
                }
                int targetNode = Integer.parseInt(st.nextToken());
                result[rIndex++] = find(currNode) == find(targetNode);
            }
            for (int i = rIndex - 1; i >= 0; i--) {
                sb.append(result[i] ? "YES\n" : "NO\n");
            }

            out.print(sb);
        }

        private void init() {
            for (int i = 1; i <= n; i++) {
                union[i] = i;
            }
        }

        private int find(int node) {
            if (union[node] == node) {
                return node;
            }
            return union[node] = find(union[node]);
        }

        private void union(int x, int y) {
            x = find(x);
            y = find(y);
            union[y] = x;
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
