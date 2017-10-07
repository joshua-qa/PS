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
        int[] visited, D;
        ArrayList<Integer>[] graph;
        int n, m, k, ans, v, vc;
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            m = in.nextInt();

            visited = new int[n+1];
            D = new int[m+1];
            graph = new ArrayList[n+1];
            for(int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            for(int i = 1; i <= n; i++) {
                k = in.nextInt();
                for(int j = 0; j < k; j++) {
                    v = in.nextInt();
                    graph[i].add(v);
                }
            }

            for(int i = 1; i <= n; i++) {
                vc++;
                if(dfs(i)) {
                    ans++;
                }
            }

            out.print(ans);
        }

        private boolean dfs(int here) {
            if(visited[here] == vc) {
                return false;
            }

            visited[here] = vc;
            for(int i : graph[here]) {
                if(D[i] == 0 || dfs(D[i])) {
                    D[i] = here;
                    return true;
                }
            }

            return false;
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