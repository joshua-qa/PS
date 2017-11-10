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
        int f, s, g, u, d, ans;
        int[] floors;
        Queue<Integer> visit = new LinkedList<>();
        public void run(InputReader in, PrintWriter out) {
            f = in.nextInt();
            s = in.nextInt();
            g = in.nextInt();
            u = in.nextInt();
            d = in.nextInt();
            ans = Integer.MAX_VALUE;
            floors = new int[f+1];
            bfs();

            if(ans == Integer.MAX_VALUE) {
                out.print("use the stairs");
            } else {
                out.print(ans);
            }
        }

        private void bfs() {
            visit.offer(s);

            while(!visit.isEmpty()) {
                int curr = visit.poll();

                if(curr == g) {
                    ans = Math.min(ans, floors[g]);
                    break;
                }

                if(curr + u <= f && curr + u != s && (floors[curr + u] == 0 || floors[curr] + 1 < floors[curr + u])) {
                    floors[curr + u] = floors[curr] + 1;
                    visit.offer(curr + u);
                }

                if(curr - d >= 1 && curr - d != s && (floors[curr - d] == 0 || floors[curr] + 1 < floors[curr - d])) {
                    floors[curr - d] = floors[curr] + 1;
                    visit.offer(curr - d);
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