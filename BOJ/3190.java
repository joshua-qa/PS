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
        class Snake {
            int x;
            int y;
            public Snake(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
        int n, m, k, currDir, seconds, len, headX, headY, tailX, tailY;
        int[] Dx = {0, -1, 0, 1};
        int[] Dy = {1, 0, -1, 0};
        int[][] map;
        boolean endFlag;
        Queue<Snake> snakes = new LinkedList<>();
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            m = in.nextInt();
            map = new int[n+2][n+2];

            for (int i = 0; i < m; i++) {
                map[in.nextInt()][in.nextInt()] = 2;
            }

            map[1][1] = 1;
            snakes.offer(new Snake(1, 1));
            headX = headY = tailX = tailY = 1;
            k = in.nextInt();
            for (int i = 0; i < k; i++) {
                int x = in.nextInt();
                char c = in.next().charAt(0);

                while(seconds < x) {
                    headX += Dx[currDir];
                    headY += Dy[currDir];
                    seconds++;
                    snakes.offer(new Snake(headX, headY));

                    if(map[headX][headY] == 2) {
                        len++;
                        map[headX][headY] = 1;
                    } else if(map[headX][headY] == 1 || isCrash(headX, headY)) {
                        endFlag = true;
                        break;
                    } else {
                        map[headX][headY] = 1;
                        map[tailX][tailY] = 0;
                        snakes.remove();
                        tailX = snakes.peek().x;
                        tailY = snakes.peek().y;
                    }
                }

                if(endFlag) {
                    break;
                }

                currDir = changeDir(currDir, c);
            }

            if(endFlag) {
                out.print(seconds);
            } else {
                while(true) {
                    headX += Dx[currDir];
                    headY += Dy[currDir];
                    seconds++;
                    snakes.offer(new Snake(headX, headY));

                    if(map[headX][headY] == 2) {
                        len++;
                        map[headX][headY] = 1;
                    } else if(map[headX][headY] == 1 || isCrash(headX, headY)) {
                        break;
                    } else {
                        map[headX][headY] = 1;
                        map[tailX][tailY] = 0;
                        snakes.remove();
                        tailX = snakes.peek().x;
                        tailY = snakes.peek().y;
                    }
                }
                out.print(seconds);
            }
        }

        private boolean isCrash(int x, int y) {
            return x == 0 || y == 0 || x == n+1 || y == n+1;
        }

        private int changeDir(int d, char c) {
            if((d == 0 && c == 'L') || (d == 2 && c == 'D')) {
                return 1;
            } else if((d == 0 && c == 'D') || (d == 2 && c == 'L')) {
                return 3;
            } else if((d == 1 && c == 'L') || (d == 3 && c == 'D')) {
                return 2;
            } else {
                return 0;
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