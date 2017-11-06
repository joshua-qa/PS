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
        StringBuilder sb = new StringBuilder();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        Queue<Integer> visit = new LinkedList<>();
        int[] parent;
        boolean[] check;
        int n, u, v;
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();

            check = new boolean[n+1];
            parent = new int[n+1];
            for(int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            for(int i = 1; i < n; i++) {
                u = in.nextInt();
                v = in.nextInt();

                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            getNode();

            for(int i = 2; i <= n; i++) {
                sb.append(parent[i]).append("\n");
            }

            out.print(sb);
        }

        private void getNode() {
            visit.add(1);
            check[1] = true;

            while(!visit.isEmpty()) {
                int currNode = visit.remove();

                for(int child : graph.get(currNode)) {
                    if(check[child]) {
                        continue;
                    } else {
                        check[child] = true;
                        parent[child] = currNode;

                        visit.add(child);
                    }
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

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}