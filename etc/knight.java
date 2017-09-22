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
        final int BOARD_SIZE = 8;
        int n, m, goalX, goalY, currX, currY;
        int[] directionX = {-1, -2, -2, -1, 1, 2, 2, 1};
        int[] directionY = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[][] chess = new int[8][8];
        boolean[][] visit = new boolean[8][8];
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            m = in.nextInt();
            goalX = in.nextInt();
            goalY = in.nextInt();

            bfs(n, m);

            if(!visit[goalX][goalY]) {
                out.println("그곳은 이동 불가능합니다.");
            } else {
                out.println("해당 위치로 이동 가능하며, 최소 " + chess[goalX][goalY] + "회 이동이 필요합니다.");
            }
        }

        private void bfs(int x, int y) {
            Queue<Knight> queue = new LinkedList<>();
            queue.add(new Knight(x, y));

            visit[x][y] = true;

            while(!queue.isEmpty()) {
                Knight curr = queue.remove();

                for(int i = 0; i < directionX.length; i++) {
                    currX = curr.x + directionX[i];
                    currY = curr.y + directionY[i];

                    if(currX < 0 || currX >= BOARD_SIZE || currY < 0 || currY >= BOARD_SIZE) {
                        continue;
                    }
                    if(visit[currX][currY] && chess[currX][currY] <= chess[curr.x][curr.y] + 1) {
                        continue;
                    } else {
                        if(!visit[currX][currY]) {
                            visit[currX][currY] = true;
                        }

                        chess[currX][currY] = chess[curr.x][curr.y] + 1;
                        queue.add(new Knight(currX, currY));
                    }
                }
            }
        }
    }

    static class Knight {
        int x;
        int y;
        public Knight(int x, int y) {
            super();
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

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}