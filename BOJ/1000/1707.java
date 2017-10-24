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
        int n, v, e, x, y;
        int[] side;
        boolean flag;
        boolean[] check;
        ArrayList<ArrayList<Integer>> graph;
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            StringBuilder sb = new StringBuilder();

            while(n-- > 0) {
                v = in.nextInt();
                e = in.nextInt();

                side = new int[v+1];
                check = new boolean[v+1];

                graph = new ArrayList<>(v+1);
                for(int i = 0; i <= v; i++) {
                    graph.add(new ArrayList<>());
                }

                for(int i = 0; i < e; i++) {
                    x = in.nextInt();
                    y = in.nextInt();

                    graph.get(x).add(y);
                    graph.get(y).add(x);
                }

                flag = true;
                for(int u = 1; u <= v; u++) {
                    if(side[u] == 0) {
                        dfs(u, 1);
                    }
                }

                for(int i = 1; i <= v; i++) {
                    for(int j : graph.get(i)) {
                        if(side[i] == side[j]) {
                            flag = false;
                        }
                    }
                }

                if(flag) {
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
                graph.clear();
            }

            out.print(sb);
        }

        private void dfs(int u, int color) {
            side[u] = color;

            for (int t : graph.get(u)) {
                if(side[t] == 0) {
                    dfs(t, 3 - color);
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