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
        int n, ans, groupNum;
        int[] dX = {-1, 0, 0, 1};
        int[] dY = {0, -1, 1, 0};
        int[][] move, map;
        boolean[][] check;
        Queue<Point> visit = new LinkedList<>();
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();

            ans = Integer.MAX_VALUE;
            map = new int[n][n];
            move = new int[n][n];
            check = new boolean[n][n];

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    map[i][j] = in.nextInt();
                }
            }

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(map[i][j] == 1 && !check[i][j]) {
                        dfs(i, j, ++groupNum);
                    }
                }
            }

            bfs();

            out.print(ans);
        }

        private void dfs(int x, int y, int groupNum) {
            check[x][y] = true;
            map[x][y] = groupNum;
            visit.offer(new Point(x, y));
            for(int i = 0; i < dX.length; i++) {
                if(x + dX[i] < 0 || x + dX[i] >= n || y + dY[i] < 0 || y + dY[i] >= n) {
                    continue;
                }
                if(map[x + dX[i]][y + dY[i]] == 1 && !check[x + dX[i]][y + dY[i]]) {
                    dfs(x + dX[i], y + dY[i], groupNum);
                }
            }
        }

        private void bfs() {
            while(!visit.isEmpty()) {
                Point p = visit.poll();

                for(int i = 0; i < dX.length; i++) {
                    int currX = p.x + dX[i];
                    int currY = p.y + dY[i];

                    if(currX < 0 || currX >= n || currY < 0 || currY >= n) {
                        continue;
                    }

                    if(map[currX][currY] == 0) {
                        map[currX][currY] = map[p.x][p.y];
                        move[currX][currY] = move[p.x][p.y] + 1;
                        visit.offer(new Point(currX, currY));
                    } else if(map[currX][currY] != map[p.x][p.y]) {
                        ans = Math.min(move[currX][currY] + move[p.x][p.y], ans);
                    }
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
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
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