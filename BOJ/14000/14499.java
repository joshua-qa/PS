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
        private final int[] dirX = {0, 0, -1, 1};
        private final int[] dirY = {1, -1, 0, 0};
        private final int EAST = 1;
        private final int WEST = 2;
        private final int NORTH = 3;
        private final int SOUTH = 4;

        private int[][] map;
        // 0 : top, 1 : east, 2 : west, 3 : north, 4 : south, 5 : bottom
        private int[] dice = {0, 2, 3, 1, 4, 5};
        private int[] currentNumber = {0, 0, 0, 0, 0, 0};
        private int n, m, currentX, currentY;
        private StringBuilder sb = new StringBuilder();
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            m = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();
            int k = in.nextInt();
            map = new int[n][m];
            currentX = x;
            currentY = y;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    map[i][j] = in.nextInt();
                }
            }

            for (int i = 0; i < k; i++) {
                int command = in.nextInt();
                int result = move(command - 1);
                if (result > -1) {
                    sb.append(result).append("\n");
                }
            }
            out.print(sb);
        }

        private int move(int dir) {
            if (currentX + dirX[dir] < 0 || currentX + dirX[dir] >= n
                || currentY + dirY[dir] < 0 || currentY + dirY[dir] >= m) {
                return -1;
            }

            currentX += dirX[dir];
            currentY += dirY[dir];
            update(dir + 1);

            return currentNumber[dice[0]];
        }

        private void update(int diceDir) {
            rotateDice(diceDir);
            if (map[currentX][currentY] == 0) {
                map[currentX][currentY] = currentNumber[dice[5]];
                return;
            }
            currentNumber[dice[5]] = map[currentX][currentY];
            map[currentX][currentY] = 0;
        }

        private void rotateDice(int diceDir) {
            /**
             *  3
             * 201
             *  4
             *  5
             */
            int temp = dice[5];
            switch (diceDir) {
                case EAST:
                    dice[5] = dice[1];
                    dice[1] = dice[0];
                    dice[0] = dice[2];
                    dice[2] = temp;
                    return;
                case WEST:
                    dice[5] = dice[2];
                    dice[2] = dice[0];
                    dice[0] = dice[1];
                    dice[1] = temp;
                    return;
                case NORTH:
                    dice[5] = dice[3];
                    dice[3] = dice[0];
                    dice[0] = dice[4];
                    dice[4] = temp;
                    return;
                case SOUTH:
                    dice[5] = dice[4];
                    dice[4] = dice[0];
                    dice[0] = dice[3];
                    dice[3] = temp;
                    return;
                default:
                    return;
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
