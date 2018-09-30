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
        Graph graph;
        int n, m, x, y, t, start, k, min = Integer.MAX_VALUE;
        final int FAIL = 999999999;
        int[] islands;
        int[][] dp;
        StringBuilder sb = new StringBuilder();
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            m = in.nextInt();
            islands = new int[n+1];
            dp = new int[n+1][501];
            for(int i = 1; i <= n; i++) {
                islands[i] = in.nextInt();
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }

            graph = new Graph(n);

            for(int i = 0; i < m; i++) {
                x = in.nextInt();
                y = in.nextInt();

                graph.put(x, y);
            }

            t = in.nextInt();

            for(int i = 0; i < t; i++) {
                start = in.nextInt();
                k = in.nextInt();

                int result = dfs(start, k);
                if(result != Integer.MAX_VALUE && result != FAIL) {
                    sb.append(dp[start][k]).append("\n");
                } else {
                    sb.append("-1\n");
                }
            }

            out.print(sb);
        }

        private int dfs(int curr, int remainMove) {
            if(graph.getNode(curr).isEmpty()) {
                return FAIL;
            }

            if(dp[curr][remainMove] != Integer.MAX_VALUE) {
                return dp[curr][remainMove];
            }

            if(remainMove == 0) {
                return islands[curr];
            }

            for(int island : graph.getNode(curr)) {
                dp[curr][remainMove] = Math.min(dp[curr][remainMove], dfs(island, remainMove-1));
            }

            return dp[curr][remainMove];
        }
    }

    static class Graph {
        private List<List<Integer>> graph;
        public Graph(int initSize) {
            this.graph = new ArrayList<>();
            for(int i = 0; i < initSize+1; i++) {
                graph.add(new ArrayList<>());
            }
        }
        public List<List<Integer>> getGraph() {
            return this.graph;
        }
        public List<Integer> getNode(int x) {
            return this.graph.get(x);
        }
        public void put(int x, int y) {
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        public void putSingle(int x, int y) {
            graph.get(x).add(y);
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