import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

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
        int ans, v, deleteNode;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        public void run(InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int[] tree = new int[n];

            for(int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }

            for(int i = 0; i < n; i++) {
                v = in.nextInt();
                tree[i] = v;
                if(v != -1) {
                    graph.get(v).add(i);
                }
            }

            for(int i = 0; i < n; i++) {
                if(graph.get(i).isEmpty()) {
                    ans++;
                }
            }

            deleteNode = in.nextInt();

            dfs(deleteNode);

            if(tree[deleteNode] != -1 && graph.get(tree[deleteNode]).size() == 1) {
                ans++;
            }

            out.println(ans);
        }

        private void dfs(int deleteNode) {
            if(graph.get(deleteNode).isEmpty()) {
                ans--;
            } else {
                for(int nextNode : graph.get(deleteNode)) {
                    dfs(nextNode);
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

    }
}