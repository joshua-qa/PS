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

    static class DSLR {
        int register;
        int count;

        public DSLR (int register, int count) {
            this.register = register;
            this.count = count;
        }
    }

    static class Task {
        int n;
        final int MOD = 10000;
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            while(n-- > 0) {
                int x = in.nextInt();
                int y = in.nextInt();

                if(x == y) {
                    out.println();
                } else {
                    out.println(solve(x, y));
                }
            }
        }

        private String solve(int x, int y) {
            int minCount = Integer.MAX_VALUE;
            String[] route = new String[10000];
            boolean[] visited = new boolean[10000];
            boolean okFlag = false;
            String result = "";
            Queue<DSLR> queue = new LinkedList<>();

            queue.offer(new DSLR(x, 0));
            visited[x] = true;
            route[x] = "";

            while(!queue.isEmpty()) {
                DSLR curr = queue.poll();
                if(curr.count >= minCount) {
                    continue;
                }

                int currNum = curr.register;
                int d = currNum * 2;
                if(d > 9999) {
                    d %= MOD;
                }
                int s = currNum - 1;
                if(s < 0) {
                    s = 9999;
                }
                int l = (currNum % 1000) * 10 + (currNum / 1000);
                int r = (currNum / 10) + (currNum % 10) * 1000;

                if(d == y) {
                    okFlag = true;
                    if(minCount > curr.count + 1) {
                        minCount = curr.count + 1;
                        result = route[currNum] + "D";
                    }
                }

                if(s == y) {
                    okFlag = true;
                    if(minCount > curr.count + 1) {
                        minCount = curr.count + 1;
                        result = route[currNum] + "S";
                    }
                }

                if(l == y) {
                    okFlag = true;
                    if(minCount > curr.count + 1) {
                        minCount = curr.count + 1;
                        result = route[currNum] + "L";
                    }
                }

                if(r == y) {
                    okFlag = true;
                    if(minCount > curr.count + 1) {
                        minCount = curr.count + 1;
                        result = route[currNum] + "R";
                    }
                }

                if(!okFlag) {
                    if (!visited[d]) {
                        visited[d] = true;
                        queue.offer(new DSLR(d, curr.count + 1));
                        route[d] = route[currNum] + "D";
                    }
                    if (!visited[s]) {
                        visited[s] = true;
                        queue.offer(new DSLR(s, curr.count + 1));
                        route[s] = route[currNum] + "S";
                    }
                    if (!visited[l]) {
                        visited[l] = true;
                        queue.offer(new DSLR(l, curr.count + 1));
                        route[l] = route[currNum] + "L";
                    }
                    if (!visited[r]) {
                        visited[r] = true;
                        queue.offer(new DSLR(r, curr.count + 1));
                        route[r] = route[currNum] + "R";
                    }
                } else {
                    okFlag = false;
                }
            }

            return result;
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