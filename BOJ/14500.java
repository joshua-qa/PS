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
        int n, m, ans, curr;
        int[][] map;
        int[][][] threeBlock1 = { {{1, 0}, {1, 0}, {1, 1}},
                                    {{1, 1}, {0, 1}, {0, 1}},
                                    {{0, 1}, {0, 1}, {1, 1}},
                                    {{1, 1}, {1, 0}, {1, 0}},
                                    {{0, 1}, {1, 1}, {1, 0}},
                                    {{1, 0}, {1, 1}, {0, 1}},
                                    {{0, 1}, {1, 1}, {0, 1}},
                                    {{1, 0}, {1, 1}, {1, 0}} };
        int[][][] threeBlock2 = { {{1, 1, 1}, {1, 0, 0}},
                                    {{0, 0, 1}, {1, 1, 1}},
                                    {{1, 1, 1}, {0, 0, 1}},
                                    {{1, 0, 0}, {1, 1, 1}},
                                    {{1, 1, 0}, {0, 1, 1}},
                                    {{0, 1, 1}, {1, 1, 0}},
                                    {{1, 1, 1}, {0, 1, 0}},
                                    {{0, 1, 0}, {1, 1, 1}} };
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            m = in.nextInt();

            map = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    map[i][j] = in.nextInt();
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    curr = search(i, j);
                    if(ans < curr) {
                        ans = curr;
                    }
                }
            }

            out.print(ans);
        }

        private int search(int x, int y) {
            int currMax = 0;
            int block = 0;

            // case 1
            if(y <= m-4) {
                block = map[x][y] + map[x][y+1] + map[x][y+2] + map[x][y+3];
                if(currMax < block) {
                    currMax = block;
                }
            }
            // case 2
            if(x <= n-4) {
                block = map[x][y] + map[x+1][y] + map[x+2][y] + map[x+3][y];
                if(currMax < block) {
                    currMax = block;
                }
            }
            // case 3
            if(x <= n-2 && y <= m-2) {
                block = map[x][y] + map[x][y+1] + map[x+1][y] + map[x+1][y+1];
                if(currMax < block) {
                    currMax = block;
                }
            }
            // case 4
            if(x <= n-3 && y <= m-2) {
                for(int i = 0; i < threeBlock1.length; i++) {
                    block = 0;
                    for(int j = x; j < x+3; j++) {
                        for(int k = y; k < y+2; k++) {
                            block += map[j][k] * threeBlock1[i][j-x][k-y];
                        }
                    }
                    if(currMax < block) {
                        currMax = block;
                    }
                }
            }
            // case 5
            if(x <= n-2 && y <= m-3) {
                for (int i = 0; i < threeBlock2.length; i++) {
                    block = 0;
                    for(int j = x; j < x+2; j++) {
                        for(int k = y; k < y+3; k++) {
                            block += map[j][k] * threeBlock2[i][j-x][k-y];
                        }
                    }
                    if(currMax < block) {
                        currMax = block;
                    }
                }
            }

            return currMax;
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