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
        int n, m, u, v, ans;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        boolean[] check;
        int[] level;
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            m = in.nextInt();

            check = new boolean[n+1];
            level = new int[n+1];
            Arrays.fill(level, 987654321);
            for(int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            for(int i = 0; i < m; i++) {
                u = in.nextInt();
                v = in.nextInt();
                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            bfs(1);

            for(int i = 2; i <= n; i++) {
                if(level[i] <= 2) {
                    ans++;
                }
            }
            out.print(ans);
        }

        private void bfs(int start) {
            Queue<Integer> visit = new LinkedList<>();

            visit.add(start);
            check[start] = true;
            level[start] = 0;

            while(!visit.isEmpty()) {
                int curr = visit.remove();

                for(int t : graph.get(curr)) {
                    level[t] = Math.min(level[t], level[curr] + 1);
                    if(!check[t]) {
                        check[t] = true;
                        visit.add(t);
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