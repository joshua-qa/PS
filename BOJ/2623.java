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
        StringBuilder sb = new StringBuilder();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        Deque<Integer> visit = new ArrayDeque<>();
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            m = in.nextInt();
            int[] indegree = new int[n+1];
            for(int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            for(int i = 0; i < m; i++) {
                int count = in.nextInt();
                u = in.nextInt();
                for(int j = 1; j < count; j++) {
                    v = in.nextInt();
                    graph.get(u).add(v);
                    indegree[v]++;
                    u = v;
                }
            }

            for(int i = 1; i <= n; i++) {
                if(indegree[i] == 0) {
                    visit.addLast(i);
                }
            }

            while(!visit.isEmpty()) {
                int curr = visit.removeFirst();
                sb.append(curr + "\n");
                ans++;

                for(int i : graph.get(curr)) {
                    indegree[i]--;

                    if(indegree[i] == 0) {
                        visit.addLast(i);
                    }
                }
            }

            if(ans != n) {
                System.out.println(0);
            } else {
                System.out.print(sb);
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