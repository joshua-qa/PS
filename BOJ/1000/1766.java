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
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        PriorityQueue<Integer> visit = new PriorityQueue<>(Comparator.naturalOrder());
        StringBuilder sb = new StringBuilder();
        int n, m, u, v;
        int[] indegree;
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            m = in.nextInt();
            indegree = new int[n+1];
            for(int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            for(int i = 0; i < m; i++) {
                u = in.nextInt();
                v = in.nextInt();

                graph.get(u).add(v);

                indegree[v]++;
            }

            for(int i = 1; i <= n; i++) {
                if(indegree[i] == 0) {
                    visit.offer(i);
                }
            }

            while(!visit.isEmpty()) {
                int curr = visit.poll();

                sb.append(curr).append(" ");

                for(int i : graph.get(curr)) {
                    indegree[i]--;

                    if(indegree[i] == 0) {
                        visit.offer(i);
                    }
                }
            }

            out.print(sb);
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