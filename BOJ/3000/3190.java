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
        /**
         * 0 : empty, 1 : body, 2 : apple
         */
        int[] dx = {0, -1, 1, 0};
        int[] dy = {-1, 0, 0, 1};
        char[] dirInfo = new char[10001];
        int[][] map;
        Deque<Pair> body = new ArrayDeque<>();
        int dir = 2, n, m, time, currX, currY, result;
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            map = new int[n][n];
            m = in.nextInt();
            for(int i = 0; i < m; i++) {
                currX = in.nextInt();
                currY = in.nextInt();
                map[--currY][--currX] = 2;
            }
            currX = currY = 0;

            body.addFirst(new Pair(0, 0));
            map[0][0] = 1;
            m = in.nextInt();
            for(int i = 0; i < m; i++) {
                time = in.nextInt();
                char c = in.next().charAt(0);
                dirInfo[time] = c;
            }

            while(true) {
                result++;
                currX += dx[dir];
                currY += dy[dir];
                if(!isMovable(currX, currY)) {
                    break;
                }
                if(map[currX][currY] != 2) {
                    Pair tail = body.removeLast();
                    map[tail.x][tail.y] = 0;
                }
                body.addFirst(new Pair(currX, currY));
                map[currX][currY] = 1;
                if(dirInfo[result] != 0) {
                    changeDir(dirInfo[result]);
                }
            }

            out.print(result);
        }

        private boolean isMovable(int x, int y) {
            return x > -1 && x < n && y > -1 && y < n && map[x][y] != 1;
        }

        private void changeDir(char nextDir) {
            switch (dir) {
                case 0 :
                    dir = (nextDir == 'L') ? 1 : 2;
                    return;
                case 1 :
                    dir = (nextDir == 'L') ? 3 : 0;
                    return;
                case 2 :
                    dir = (nextDir == 'L') ? 0 : 3;
                    return;
                case 3 :
                    dir = (nextDir == 'L') ? 2 : 1;
                    return;
            }
        }
    }

    static class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
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