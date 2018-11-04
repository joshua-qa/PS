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
        int m, n, count, result;
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};
        int[][] map;
        Queue<Point> queue = new LinkedList<>();
        public void run(InputReader in, PrintWriter out) {
            m = in.nextInt();
            n = in.nextInt();
            map = new int[n][m];
            count = m * n;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    map[i][j] = in.nextInt();
                    if(map[i][j] == 1) {
                        queue.add(new Point(i, j));
                    }

                    if(map[i][j] != 0) {
                        count--;
                    }
                }
            }

            if(queue.isEmpty()) {
                out.print("-1");
                return;
            }

            if(count == 0) {
                out.print("0");
                return;
            }

            bfs();

            if(count != 0) {
                out.print("-1");
                return;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(map[i][j] > result) {
                        result = map[i][j];
                    }
                }
            }

            out.print(--result);
        }

        private void bfs() {
            while(!queue.isEmpty()) {
                Point p = queue.poll();

                for (int i = 0; i < dx.length; i++) {
                    int currX = p.x + dx[i];
                    int currY = p.y + dy[i];

                    if(judge(currX, currY) || map[currX][currY] == -1) {
                        continue;
                    }

                    if(map[currX][currY] == 0 || map[currX][currY] > map[p.x][p.y] + 1) {
                        if(map[currX][currY] == 0) {
                            count--;
                        }
                        map[currX][currY] = map[p.x][p.y] + 1;
                        queue.add(new Point(currX, currY));
                    }
                }
            }
        }

        private boolean judge(int x, int y) {
            return x < 0 || x >= n || y < 0 || y >= m;
        }
    }

    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
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