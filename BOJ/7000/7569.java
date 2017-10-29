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

    static class Tomato {
        int x;
        int y;
        int z;
        public Tomato(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static class Task {
        int[] dX = {-1, 0, 0, 1, 0, 0};
        int[] dY = {0, -1, 1, 0, 0, 0};
        int[] dZ = {0, 0, 0, 0, 1, -1};
        int m, n, h, ans, empty;
        int[][][] map;
        boolean clearFlag;
        Queue<Tomato> visit = new LinkedList<>();
        public void run(InputReader in, PrintWriter out) {
            m = in.nextInt();
            n = in.nextInt();
            h = in.nextInt();
            empty = m * n * h;

            map = new int[h][n][m];

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < m; k++) {
                        map[i][j][k] = in.nextInt();
                        if(map[i][j][k] == 1) {
                            empty--;
                            visit.add(new Tomato(j, k, i));
                        } else if(map[i][j][k] == -1) {
                            empty--;
                        }
                    }
                }
            }

            if(empty != 0) {
                bfs();
            } else {
                clearFlag = true;
            }

            if(empty > 0) {
                ans = -1;
            } else if(empty == 0 && !clearFlag) {
                for (int i = 0; i < h; i++) {
                    for (int j = 0; j < n; j++) {
                        for (int k = 0; k < m; k++) {
                            if (map[i][j][k] > ans) {
                                ans = map[i][j][k];
                            }
                        }
                    }
                }

                ans--;
            }
            out.print(ans);
        }

        private void bfs() {
            int currX = 0;
            int currY = 0;
            int currZ = 0;

            while(!visit.isEmpty()) {
                Tomato curr = visit.remove();

                for(int i = 0; i < dX.length; i++) {
                    currX = curr.x + dX[i];
                    currY = curr.y + dY[i];
                    currZ = curr.z + dZ[i];

                    if(check(currX, currY, currZ) || map[currZ][currX][currY] == -1) {
                        continue;
                    }

                    if(map[currZ][currX][currY] == 0 || map[currZ][currX][currY] > map[curr.z][curr.x][curr.y] + 1) {
                        if(map[currZ][currX][currY] == 0) {
                            empty--;
                        }
                        map[currZ][currX][currY] = map[curr.z][curr.x][curr.y] + 1;
                        visit.add(new Tomato(currX, currY, currZ));
                    }
                }
            }
        }

        private boolean check(int x, int y, int z) {
            return x < 0 || x >= n || y < 0 || y >= m || z < 0 || z >= h;
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