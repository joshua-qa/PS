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
        public static final int EMPTY = 0;
        public static final int WATER = 1;
        public static final int STONE = 2;
        public static final int HEDGEHOG = 3;
        public static final int GOAL = 4;
        public static final int MAX = 1000000;
        private int r, c, goalX, goalY;
        private int[] dirX = {0, -1, 1, 0};
        private int[] dirY = {-1, 0, 0, 1};
        private int[][] map, bfsMap, waterMap;
        private Queue<Point> hedgehogVisit = new LinkedList<>();
        private Queue<Point> waterMove = new LinkedList<>();
        public void run(InputReader in, PrintWriter out) {
            r = in.nextInt();
            c = in.nextInt();
            map = new int[r][c];
            bfsMap = new int[r][c];
            waterMap = new int[r][c];
            for (int i = 0; i < r; i++) {
                Arrays.fill(bfsMap[i], MAX);
                Arrays.fill(waterMap[i], MAX);
                char[] line = in.nextLine().toCharArray();
                for (int j = 0; j < c; j++) {
                    map[i][j] = getState(line[j]);
                    if (map[i][j] == WATER) {
                        waterMove.add(new Point(i, j));
                        waterMap[i][j] = 0;
                    } else if(map[i][j] == GOAL) {
                        goalX = i;
                        goalY = j;
                    } else if(map[i][j] == HEDGEHOG) {
                        bfsMap[i][j] = 0;
                        hedgehogVisit.add(new Point(i, j));
                    }
                }
            }

            fillWater();
            bfs();
            if (bfsMap[goalX][goalY] == MAX) {
                out.print("KAKTUS");
            } else {
                out.print(bfsMap[goalX][goalY]);
            }
        }

        private void fillWater() {
            while (!waterMove.isEmpty()) {
                Point water = waterMove.poll();
                int waterX = water.getX();
                int waterY = water.getY();
                for (int i = 0; i < dirX.length; i++) {
                    int currX = waterX + dirX[i];
                    int currY = waterY + dirY[i];
                    if (currX < 0 || currX >= r || currY < 0 || currY >= c) {
                        continue;
                    }
                    if (waterMap[currX][currY] > waterMap[waterX][waterY] + 1 && isMovable(WATER, currX, currY)) {
                        waterMap[currX][currY] = waterMap[waterX][waterY] + 1;
                        waterMove.add(new Point(currX, currY));
                    }
                }
            }
        }

        private void bfs() {
            while (!hedgehogVisit.isEmpty()) {
                Point hedgeHog = hedgehogVisit.poll();
                int x = hedgeHog.getX();
                int y = hedgeHog.getY();
                if (map[x][y] == GOAL) {
                    continue;
                }
                for (int i = 0; i < dirX.length; i++) {
                    int currX = x + dirX[i];
                    int currY = y + dirY[i];
                    if (currX < 0 || currX >= r || currY < 0 || currY >= c) {
                        continue;
                    }
                    if (waterMap[currX][currY] <= bfsMap[x][y] + 1 || !isMovable(HEDGEHOG, currX, currY)) {
                        continue;
                    }
                    if (bfsMap[currX][currY] > bfsMap[x][y] + 1) {
                        bfsMap[currX][currY] = bfsMap[x][y] + 1;
                        hedgehogVisit.add(new Point(currX, currY));
                    }
                }
            }
        }

        private boolean isMovable(int currentState, int x, int y) {
            if (currentState == WATER) {
                return map[x][y] == EMPTY;
            }
            return map[x][y] == EMPTY || map[x][y] == GOAL;
        }

        private int getState(char column) {
            switch (column) {
                case '*':
                    return WATER;
                case 'X':
                    return STONE;
                case 'S':
                    return HEDGEHOG;
                case 'D':
                    return GOAL;
                default:
                    return EMPTY;
            }
        }

        static class Point {
            private int x;
            private int y;

            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }

            public int getX() {
                return x;
            }

            public int getY() {
                return y;
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
