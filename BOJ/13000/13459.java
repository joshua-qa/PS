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
        int n, m, blueX, blueY, redX, redY;
        int[][] map;
        int[] dX = {-1, 0, 0, 1};
        int[] dY = {0, -1, 1, 0};
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            m = in.nextInt();
            map = new int[n][m];

            for(int i = 0; i < n; i++) {
                char[] line = in.next().toCharArray();
                for(int j = 0; j < m; j++) {
                    switch (line[j]) {
                        case '#':
                            map[i][j] = 9;
                            continue;
                        case 'O':
                            map[i][j] = 8;
                            continue;
                        case 'R':
                            redX = i;
                            redY = j;
                            continue;
                        case 'B':
                            blueX = i;
                            blueY = j;
                            continue;
                    }
                }
            }

            int ans = bfs();
            if(ans == -1 || ans > 10) {
                out.println("0");
            } else {
                out.println("1");
            }
        }

        private int bfs() {
            int ans = -1;
            int[][] move = new int[n][m];

            Queue<Ball> redQueue = new LinkedList<>();
            Queue<Ball> blueQueue = new LinkedList<>();

            redQueue.add(new Ball(redX, redY, 0));
            blueQueue.add(new Ball(blueX, blueY, 0));

            while(!redQueue.isEmpty()) {
                Ball redBall = redQueue.remove();
                Ball blueBall = blueQueue.remove();

                for(int i = 0; i < dX.length; i++) {
                    int rX = redBall.x;
                    int rY = redBall.y;
                    int rM = redBall.moveCount;
                    int bX = blueBall.x;
                    int bY = blueBall.y;
                    int bM = blueBall.moveCount;
                    int currBallCount = 0;
                    int m = rM + 1;
                    boolean bHole = false;
                    boolean rHole = false;
                    if(ans > 0 && m > ans) {
                        continue;
                    }
                    move[rX][rY] = m;
                    if(!check(rX, rY, bX, bY, i, 0) && !check(rX, rY, bX, bY, i, 1)) {
                        continue;
                    }

                    while(true) {
                        boolean rCheck = check(rX, rY, bX, bY, i, 0);
                        boolean bCheck = check(rX, rY, bX, bY, i, 1);
                        if(rHole) {
                            rCheck = false;
                        }
                        if(!rCheck && !bCheck) {
                            break;
                        }
                        if(rCheck && !rHole) {
                            move[rX+dX[i]][rY+dY[i]] = m;
                            rX += dX[i];
                            rY += dY[i];
                            if(map[rX][rY] == 8) {
                                rHole = true;
                                currBallCount = move[rX][rY];
                            }
                        }
                        if(bCheck) {
                            bX += dX[i];
                            bY += dY[i];
                        }
                        if(map[bX][bY] == 8 || map[bX+dX[i]][bY+dY[i]] == 8) {
                            bHole = true;
                            currBallCount = -1;
                            break;
                        }
                    }
                    if(bHole) {
                        continue;
                    }

                    if(m > 10) {
                        continue;
                    }
                    if(currBallCount == 0 && m <= 10) {
                        redQueue.add(new Ball(rX, rY, m));
                        blueQueue.add(new Ball(bX, bY, m));
                    } else if(currBallCount > 0) {
                        if(ans == -1) {
                            ans = currBallCount;
                        } else {
                            ans = Math.min(currBallCount, ans);
                        }
                    }
                }
            }

            return ans;
        }

        // red 0, blue 1
        private boolean check(int rX, int rY, int bX, int bY, int dir, int ball) {
            if(ball == 0) {
                if(map[rX+dX[dir]][rY+dY[dir]] == 9) {
                    return false;
                } else if(rX + dX[dir] == bX && rY + dY[dir] == bY) {
                    return false;
                }
            } else {
                if(map[bX+dX[dir]][bY+dY[dir]] == 9) {
                    return false;
                } else if(bX + dX[dir] == rX && bY + dY[dir] == rY) {
                    return false;
                }
            }
            return true;
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

class Ball {
    int x;
    int y;
    int moveCount;

    public Ball(int x, int y, int m) {
        super();
        this.x = x;
        this.y = y;
        this.moveCount = m;
    }
}