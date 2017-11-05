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
        int n, m, size;
        int[] parent, totalDist, min;
        int[][] dist;
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            m = in.nextInt();

            min = new int[n+1];
            totalDist = new int[n+1];
            parent = new int[n+1];
            dist = new int[n+1][n+1];
            for(int i = 1; i <= n; i++) {
                Arrays.fill(dist[i], 1, n+1, INF);
                parent[i] = i;
                min[i] = INF;
            }

            for(int i = 0; i < m; i++) {
                int u = in.nextInt();
                int v = in.nextInt();

                dist[u][v] = 1;
                dist[v][u] = 1;
            }

            for(int k = 1; k <= n; k++) {
                for(int i = 1; i <= n; i++) {
                    for(int j = 1; j <= n; j++) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }

            for(int i = 1; i <= n; i++) {
                for(int j = i; j <= n; j++) {
                    if(dist[i][j] == INF || parent[j] != j) {
                        continue;
                    }

                    union(i, j);
                }
            }

            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(i == j || dist[i][j] == INF) {
                        continue;
                    }

                    totalDist[i] = Math.max(dist[j][i], totalDist[i]);
                }
                if(min[parent[i]] != INF) {
                    if(totalDist[min[parent[i]]] > totalDist[i]) {
                        min[parent[i]] = i;
                    }
                } else {
                    min[parent[i]] = i;
                    size++;
                }
            }

            out.println(size);
            Arrays.sort(min);

            for(int i = 1; i <= size; i++) {
                out.println(min[i]);
            }
        }

        private int find(int n) {
            if(parent[n] == n) {
                return n;
            }
            return parent[n] = find(parent[n]);
        }

        private void union(int a, int b) {
            a = find(a);
            b = find(b);
            if(a == b) {
                return;
            }
            parent[b] = a;
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