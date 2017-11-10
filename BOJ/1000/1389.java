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
        final int INF = 987654321;
        int n, m, u, v, ans, minDist;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int[][] dist;
        Queue<Integer> visit = new LinkedList<>();
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            m = in.nextInt();

            for(int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            dist = new int[n+1][n+1];
            minDist = INF;
            for(int i = 0; i < m; i++) {
                u = in.nextInt();
                v = in.nextInt();

                graph.get(u).add(v);
                graph.get(v).add(u);

                dist[u][v] = 1;
                dist[v][u] = 1;
            }

            for(int i = 1; i <= n; i++) {
                bfs(i);
                int curr = 0;
                for(int j = 1; j <= n; j++) {
                    if(j != i) {
                        curr += dist[i][j];
                    }
                }

                if(minDist > curr) {
                    minDist = curr;
                    ans = i;
                }
            }

            out.print(ans);
        }

        private void bfs(int i) {
            boolean[] check = new boolean[n+1];

            visit.offer(i);
            check[i] = true;

            while(!visit.isEmpty()) {
                int curr = visit.poll();

                for(int v : graph.get(curr)) {
                    if(check[v]) {
                        continue;
                    }

                    if(dist[i][v] == 0 || dist[i][curr] + 1 < dist[i][v]) {
                        dist[i][v] = dist[i][curr] + 1;
                    }

                    check[v] = true;
                    visit.offer(v);
                }
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

    }
}