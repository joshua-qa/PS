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
        final int INF = 1000000009;
        final int MAX = 100000;
        int a, b, n, m, curr;
        int[] map = new int[MAX + 1];
        StringBuilder sb = new StringBuilder();
        public void run(InputReader in, PrintWriter out) {
            a = in.nextInt();
            b = in.nextInt();
            n = in.nextInt();
            m = in.nextInt();

            Arrays.fill(map, INF);
            bfs();

            out.print(map[m]);
        }

        private void bfs() {
            Queue<Integer> visit = new LinkedList<>();

            map[n] = 0;

            visit.offer(n);

            while(!visit.isEmpty()) {
                int curr = visit.poll();

                if(curr == m) {
                    break;
                }

                if(curr + a <= MAX && map[curr + a] > map[curr] + 1) {
                    map[curr + a] = map[curr] + 1;
                    visit.offer(curr + a);
                }

                if(curr + b <= MAX && map[curr + b] > map[curr] + 1) {
                    map[curr + b] = map[curr] + 1;
                    visit.offer(curr + b);
                }

                if(curr - a >= 0 && map[curr - a] > map[curr] + 1) {
                    map[curr - a] = map[curr] + 1;
                    visit.offer(curr - a);
                }

                if(curr - b >= 0 && map[curr - b] > map[curr] + 1) {
                    map[curr - b] = map[curr] + 1;
                    visit.offer(curr - b);
                }

                if(curr + 1 <= MAX && map[curr + 1] > map[curr] + 1) {
                    map[curr + 1] = map[curr] + 1;
                    visit.offer(curr + 1);
                }

                if(curr - 1 >= 0 && map[curr - 1] > map[curr] + 1) {
                    map[curr - 1] = map[curr] + 1;
                    visit.offer(curr - 1);
                }

                if(curr * a <= MAX && map[curr * a] > map[curr] + 1) {
                    map[curr * a] = map[curr] + 1;
                    visit.offer(curr * a);
                }

                if(curr * b <= MAX && map[curr * b] > map[curr] + 1) {
                    map[curr * b] = map[curr] + 1;
                    visit.offer(curr * b);
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

        public String nextLine() {
            String s;
            try {
                s = reader.readLine();
            } catch (Exception e) {
                return "-1";
            }
            if(s == null || s.equals("")) {
                return "-1";
            }

            return s;
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