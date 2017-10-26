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

    static class Edge {
        int index;
        int dist;
        public Edge(int index, int dist) {
            this.index = index;
            this.dist = dist;
        }
    }

    static class Task {
        int n, u, v, d, curr;
        int[] dist;
        Queue<Integer> visit = new LinkedList<>();
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            for(int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            for(int i = 0; i < n-1; i++) {
                u = in.nextInt();
                v = in.nextInt();
                d = in.nextInt();
                graph.get(u).add(new Edge(v, d));
                graph.get(v).add(new Edge(u, d));
            }

            int t = bfs(1);
            int ans = bfs(t);

            out.print(dist[ans]);
        }

        private int bfs(int start) {
            int result = -1;
            dist = new int[n+1];

            visit.add(start);

            while(!visit.isEmpty()) {
                curr = visit.remove();

                for(Edge e : graph.get(curr)) {
                    if(dist[e.index] == 0) {
                        dist[e.index] = dist[curr] + e.dist;
                        visit.add(e.index);
                    }
                }
            }

            int maxDist = 0;
            for(int i = 1; i <= n; i++) {
                if(maxDist < dist[i]) {
                    maxDist = dist[i];
                    result = i;
                }
            }

            return result;
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