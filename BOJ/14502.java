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

    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Task {
        int[] Dx = {-1, 0, 0, 1};
        int[] Dy = {0, -1, 1, 0};
        int[][] map;
        int n, m, ax, ay, bx, by, cx, cy, available, max, res, currX, currY;
        Queue<Point> visit = new LinkedList<>();
        ArrayList<Point> virusList = new ArrayList<>();
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            m = in.nextInt();
            map = new int[n][m];
            max = n * m;
            available = max - 3;

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    map[i][j] = in.nextInt();
                    if(map[i][j] != 0) {
                        available--;
                        if(map[i][j] == 2) {
                            virusList.add(new Point(i, j));
                        }
                    }
                }
            }

            for(int i = 0; i < max - 2; i++) {
                ax = i / m;
                ay = i % m;
                if(map[ax][ay] != 0) {
                    continue;
                }
                map[ax][ay] = 1;
                for(int j = i+1; j < max - 1; j++) {
                    bx = j / m;
                    by = j % m;
                    if(map[bx][by] != 0) {
                        continue;
                    }
                    map[bx][by] = 1;
                    for(int k = j+1; k < max; k++) {
                        cx = k / m;
                        cy = k % m;
                        if(map[cx][cy] != 0) {
                            continue;
                        }
                        map[cx][cy] = 1;
                        int curr = bfs();
                        if(curr > res) {
                            res = curr;
                        }
                        map[cx][cy] = 0;
                    }
                    map[bx][by] = 0;
                }
                map[ax][ay] = 0;
            }

            out.print(res);
        }

        private int bfs() {
            boolean[][] check = new boolean[n][m];
            int ans = 0;
            for(Point p : virusList) {
                visit.add(p);
                check[p.x][p.y] = true;
            }

            while(!visit.isEmpty()) {
                Point p = visit.remove();

                for(int i = 0; i < Dx.length; i++) {
                    currX = p.x + Dx[i];
                    currY = p.y + Dy[i];
                    if(currX < 0 || currX >= n || currY < 0 || currY >= m) {
                        continue;
                    }
                    if(!check[currX][currY] && map[currX][currY] == 0) {
                        check[currX][currY] = true;
                        ans++;
                        visit.add(new Point(currX, currY));
                    }
                }
            }
            return available - ans;
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