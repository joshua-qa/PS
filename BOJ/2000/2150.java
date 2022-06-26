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
        List<List<Integer>> graph = new ArrayList<>();
        List<List<Integer>> reverse = new ArrayList<>();
        List<List<Integer>> scc = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] visit;
        int n, m;
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }
            m = in.nextInt();
            for (int i = 0; i < m; i++) {
                graph.get(in.nextInt()).add(in.nextInt());
            }
            scc();

            StringBuilder sb = new StringBuilder();
            sb.append(scc.size()).append("\n");
            scc.sort(Comparator.comparingInt(o -> o.get(0)));
            for (List<Integer> group : scc) {
                for (int node : group) {
                    sb.append(node).append(" ");
                }
                sb.append("-1\n");
            }
            out.print(sb);
        }

        private void scc() {
            visit = new boolean[n+1];
            for (int i = 0; i <= n; i++) {
                reverse.add(new ArrayList<>());
            }
            for (int i = 1; i <= n; i++) {
                for (Integer target : graph.get(i)) {
                    reverse.get(target).add(i);
                }
            }

            for (int i = 1; i <= n; i++) {
                if (!visit[i]) {
                    dfs(i);
                }
            }

            Arrays.fill(visit, false);
            int groupNum = 0;
            while (!stack.isEmpty()) {
                int node = stack.pollLast();
                if (visit[node]) {
                    continue;
                }
                scc.add(new ArrayList<>());
                searchSccNode(groupNum, node);
                Collections.sort(scc.get(groupNum++));
            }
        }

        private void dfs(int curr) {
            visit[curr] = true;
            for (int target : graph.get(curr)) {
                if (!visit[target]) {
                    dfs(target);
                }
            }
            stack.offer(curr);
        }

        private void searchSccNode(int sccNum, int curr) {
            visit[curr] = true;
            scc.get(sccNum).add(curr);
            for (int target : reverse.get(curr)) {
                if (!visit[target]) {
                    searchSccNode(sccNum, target);
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
