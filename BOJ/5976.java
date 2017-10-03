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
        int n, curr;
        int[][] map;
        int[] dirX = {0, 1, 0, -1};
        int[] dirY = {1, 0, -1, 0};
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            map = new int[n][n];

            int direction = 0;
            int num = 1;
            map[0][0] = 1;
            int x = 0, y = 0;
            StringBuilder sb = new StringBuilder();

            while(++num <= n*n) {
                map[x + dirX[direction]][y + dirY[direction]] = num;
                x += dirX[direction];
                y += dirY[direction];
                if(x + dirX[direction] < 0 || x + dirX[direction] >= n || y + dirY[direction] < 0 || y + dirY[direction] >= n || map[x + dirX[direction]][y + dirY[direction]] != 0) {
                    direction = direction == 3 ? 0 : direction+1;
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sb.append(map[i][j] + " ");
                }
                sb.append("\n");
            }
            out.print(sb);
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