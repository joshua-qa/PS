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
        public Edge(int i, int d) {
            this.index = i;
            this.dist = d;
        }
    }

    static class Task {
        int n, x, y, d, t, ans;
        int[] dist;
        boolean[] check;
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        Queue<Integer> visit = new LinkedList<>();
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            dist = new int[n+1];
            check = new boolean[n+1];
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 1; i <= n; i++) {
                x = in.nextInt();
                while(true) {
                    y = in.nextInt();
                    if(y == -1) {
                        break;
                    }

                    d = in.nextInt();

                    graph.get(x).add(new Edge(y, d));
                }
            }
            t = bfs(1);
            Arrays.fill(dist, 0);
            Arrays.fill(check, false);
            ans = bfs(t);

            out.print(dist[ans]);
        }

        private int bfs(int start) {
            visit.add(start);
            check[start] = true;

            while(!visit.isEmpty()) {
                int curr = visit.remove();

                for(Edge next : graph.get(curr)) {
                    if(check[next.index]) {
                        continue;
                    }
                    if(dist[curr] + next.dist > dist[next.index]) {
                        dist[next.index] = dist[curr] + next.dist;
                        check[next.index] = true;

                        visit.add(next.index);
                    }
                }
            }

            int result = 1;
            for(int i = 2; i <= n; i++) {
                if(dist[result] < dist[i]) {
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