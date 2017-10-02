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
        int n, m, currX, currY;
        final int MAX = 987654321;
        int[] directionX = {-1, 0, 0, 1};
        int[] directionY = {0, -1, 1, 0};
        char[][] map;
        int[][] result;
        int[][] noBreakResult;
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            m = in.nextInt();
            map = new char[n][m];
            result = new int[n][m];
            noBreakResult = new int[n][m];
            for (int i = 0; i < result.length; i++) {
                Arrays.fill(result[i], MAX);
                Arrays.fill(noBreakResult[i], MAX);
            }

            for (int i = 0; i < n; i++) {
                map[i] = in.next().toCharArray();
            }

            bfs(0, 0);

            if(result[n-1][m-1] != MAX) {
                out.print(result[n-1][m-1]);
            } else {
                out.print(-1);
            }
        }

        private void bfs(int x, int y) {
            Queue<Move> visit = new LinkedList<>();

            visit.add(new Move(x, y, 0));
            result[x][y] = 1;
            noBreakResult[x][y] = 1;

            while(!visit.isEmpty()) {
                Move curr = visit.remove();

                for (int i = 0; i < directionX.length; i++) {
                    currX = curr.x + directionX[i];
                    currY = curr.y + directionY[i];

                    if(currX < 0 || currX >= n || currY < 0 || currY >= m) {
                        continue;
                    }

                    if(curr.broken == 1 && map[currX][currY] == '1') {
                        continue;
                    }

                    if(curr.broken == 0) {
                        if(map[currX][currY] == '1') {
                            if(result[currX][currY] > noBreakResult[curr.x][curr.y] + 1) {
                                result[currX][currY] = noBreakResult[curr.x][curr.y] + 1;
                            }
                            visit.add(new Move(currX, currY, 1));
                        } else {
                            if(noBreakResult[currX][currY] > noBreakResult[curr.x][curr.y] + 1) {
                                noBreakResult[currX][currY] = noBreakResult[curr.x][curr.y] + 1;
                                visit.add(new Move(currX, currY, 0));
                            }
                            if(result[currX][currY] > result[curr.x][curr.y] + 1) {
                                result[currX][currY] = result[curr.x][curr.y] + 1;
                                visit.add(new Move(currX, currY, 0));
                            }
                        }
                    }

                    if(curr.broken == 1 && result[currX][currY] > result[curr.x][curr.y] + 1) {
                        result[currX][currY] = result[curr.x][curr.y] + 1;

                        if(map[currX][currY] == '1') {
                            visit.add(new Move(currX, currY, 1));
                        } else {
                            visit.add(new Move(currX, currY, curr.broken));
                        }
                    }
                }
            }
        }

        static class Move {
            int x;
            int y;
            int broken;

            public Move(int x, int y, int broken) {
                this.x = x;
                this.y = y;
                this.broken = broken;
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