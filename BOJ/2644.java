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
        int n, m, x, y, queryA, queryB, ans;
        private ArrayList<ArrayList<Integer>> graph;
        boolean[][] check;
        int[][] relation;
        Queue<Integer> visit = new LinkedList<>();
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            queryA = in.nextInt();
            queryB = in.nextInt();
            m = in.nextInt();
            graph = new ArrayList<>(n+1);
            for(int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            for(int i = 0; i < m; i++) {
                x = in.nextInt();
                y = in.nextInt();
                graph.get(x).add(y);
                graph.get(y).add(x);
            }

            ans = bfs();

            out.print(ans);
        }

        private int bfs() {
            relation = new int[n+1][n+1];
            
            check = new boolean[n+1][n+1];

            visit.add(queryA);

            while(!visit.isEmpty()) {
                int curr = visit.remove();

                for(int v : graph.get(curr)) {
                    if(!check[curr][v]) {
                        check[curr][v] = true;
                        relation[curr][v] = 1;
                        if(relation[queryA][v] == 0 || relation[queryA][v] > relation[queryA][curr] + 1) {
                            relation[queryA][v] = relation[queryA][curr] + 1;
                        }
                        visit.add(v);
                    }
                }
            }

            return relation[queryA][queryB] == 0 ? -1 : relation[queryA][queryB];
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