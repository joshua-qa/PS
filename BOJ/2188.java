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
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int n, m, si, v, vc;
        int[] D;
        int[] visited;
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            m = in.nextInt();

            D = new int[n+1];
            visited = new int[n+1];

            for(int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            for(int i = 1; i <= n; i++) {
                si = in.nextInt();
                for(int j = 0; j < si; j++) {
                    v = in.nextInt();
                    graph.get(i).add(v);
                }
            }

            out.print(solve());
        }

        private int solve() {
            int ans = 0;

            for(int i = 1; i <= n; i++) {
                vc++;
                if(dfs(i)) {
                    ans++;
                }
            }

            return ans;
        }

        private boolean dfs(int here) {
            if(visited[here] == vc) {
                return false;
            }

            visited[here] = vc;
            for(int i : graph.get(here)) {
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

        public InputReader(String fileName) {
            try {
                reader = new BufferedReader(new FileReader(fileName));
                tokenizer = null;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

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