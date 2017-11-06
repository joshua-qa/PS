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

    static class Vertex implements Comparable<Vertex> {
        int index;
        int dist;

        public Vertex(int index, int dist) {
            this.index = index;
            this.dist = dist;
        }

        @Override
        public int compareTo(Vertex that) {
            if(this.dist > that.dist) {
                return 1;
            } else if(this.dist < that.dist) {
                return -1;
            }

            return 0;
        }
    }

    static class Task {
        PriorityQueue<Vertex> visit = new PriorityQueue<>();
        ArrayList<ArrayList<Vertex>> graph = new ArrayList<>();
        ArrayList<ArrayList<Vertex>> returnGraph = new ArrayList<>();
        int n, m, x, u, v, d;
        int[] returnDist, dist;
        final int INF = 1000000009;
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            m = in.nextInt();
            x = in.nextInt();

            for(int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
                returnGraph.add(new ArrayList<>());
            }

            for(int i = 0; i < m; i++) {
                u = in.nextInt();
                v = in.nextInt();
                d = in.nextInt();

                graph.get(u).add(new Vertex(v, d));
                returnGraph.get(v).add(new Vertex(u, d));
            }

            dist = new int[n+1];
            returnDist = new int[n+1];
            Arrays.fill(returnDist, INF);

            returnDist[x] = 0;

            visit.offer(new Vertex(x, 0));

            while(!visit.isEmpty()) {
                Vertex curr = visit.poll();

                for(Vertex v : returnGraph.get(curr.index)) {
                    if(returnDist[v.index] > returnDist[curr.index] + v.dist) {
                        returnDist[v.index] = returnDist[curr.index] + v.dist;

                        visit.add(new Vertex(v.index, returnDist[v.index]));
                    }
                }
            }

            Arrays.fill(dist, INF);

            dist[x] = 0;

            visit.offer(new Vertex(x, 0));

            while(!visit.isEmpty()) {
                Vertex curr = visit.poll();

                for(Vertex v : graph.get(curr.index)) {
                    if(dist[v.index] > dist[curr.index] + v.dist) {
                        dist[v.index] = dist[curr.index] + v.dist;

                        visit.add(new Vertex(v.index, dist[v.index]));
                    }
                }
            }

            int ans = -1;

            for(int i = 1; i <= n; i++) {
                if(i == x) {
                    continue;
                }

                int currDist = returnDist[i] + dist[i];
                if(currDist > ans) {
                    ans = currDist;
                }
            }

            out.print(ans);
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