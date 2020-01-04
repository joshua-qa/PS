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
        int n, m, x, y, currMax = -1;
        ArrayList<Integer>[] graph;
        boolean[] visit;
        int[] counts;
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            m = in.nextInt();
            counts = new int[n+1];
            graph = new ArrayList[n+1];
            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int i = 0; i < m; i++) {
                x = in.nextInt();
                y = in.nextInt();
                graph[x].add(y);
            }
            for (int i = 1; i <= n; i++) {
                visit = new boolean[n+1];
                bfs(i);
            }

            for (int i = 1; i <= n; i++) {
                if (currMax < counts[i]) {
                    currMax = counts[i];
                }
            }

            for (int i = 1; i <= n; i++) {
                if (currMax == counts[i]) {
                    out.write(i + " ");
                }
            }
            out.flush();
        }

        private void bfs(int node) {
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(node);
            visit[node] = true;
            while (!queue.isEmpty()) {
                int curr = queue.poll();
                for (int i : graph[curr]) {
                    if (!visit[i]) {
                        visit[i] = true;
                        counts[i]++;
                        queue.offer(i);
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
