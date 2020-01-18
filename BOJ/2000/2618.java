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
        int n, w, x, y, result = 987654321;
        int[][] dp, map, currentInfo;
        Stack<Integer> stack = new Stack<>();
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            w = in.nextInt();
            map = new int[w+1][2];
            dp = new int[w+1][w+1];
            currentInfo = new int[w+1][w+1];
            for (int i = 1; i <= w; i++) {
                map[i][0] = in.nextInt();
                map[i][1] = in.nextInt();
            }

            dp[1][0] = getDistance(1, 1, map[1][0], map[1][1]);
            dp[0][1] = getDistance(n, n, map[1][0], map[1][1]);
            for (int i = 0; i < w; i++) {
                dp[i][i+1] = dp[i][0] + getDistance(n, n, map[i+1][0], map[i+1][1]);
                dp[i+1][i] = dp[0][i] + getDistance(1, 1, map[i+1][0], map[i+1][1]);
                currentInfo[i][i+1] = 0;
                currentInfo[i+1][i] = 0;
                for (int j = 1; j < i; j++) {
                    int curr = getDistance(map[j][0], map[j][1], map[i+1][0], map[i+1][1]);
                    if (dp[i][i+1] > curr + dp[i][j]) {
                        dp[i][i+1] = curr + dp[i][j];
                        currentInfo[i][i+1] = j;
                    }
                    if (dp[i+1][i] > curr + dp[j][i]) {
                        dp[i+1][i] = curr + dp[j][i];
                        currentInfo[i+1][i] = j;
                    }
                }

                for (int j = i+2; j <= w; j++) {
                    dp[i][j] = dp[i][j-1] + getDistance(map[j-1][0], map[j-1][1], map[j][0], map[j][1]);
                    currentInfo[i][j] = j-1;
                    dp[j][i] = dp[j-1][i] + getDistance(map[j-1][0], map[j-1][1], map[j][0], map[j][1]);
                    currentInfo[j][i] = j-1;
                }
            }
            for (int i = 0; i < w; i++) {
                if (dp[i][w] < result) {
                    result = dp[i][w];
                    x = i;
                    y = w;
                }
                if (dp[w][i] < result) {
                    result = dp[w][i];
                    x = w;
                    y = i;
                }
            }

            out.println(result);
            while (x + y > 1) {
                if (x > y) {
                    stack.push(1);
                    x = currentInfo[x][y];
                } else if (y > x) {
                    stack.push(2);
                    y = currentInfo[x][y];
                }
            }
            stack.push(x == 1 ? 1 : 2);
            while (!stack.isEmpty()) {
                out.println(stack.pop());
            }
        }

        private int getDistance(int ax, int ay, int bx, int by) {
            return abs(bx - ax) + abs(by - ay);
        }

        private int abs(int x) {
            return (x < 0) ? -x : x;
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
