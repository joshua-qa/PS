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
        public static final int MAX = 1000000000;
        private int n;
        private int[][] house, dpFirst, dpSecond, dpThird;
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            house = new int[n+1][n+1];
            dpFirst = new int[n+1][n+1];
            dpSecond = new int[n+1][n+1];
            dpThird = new int[n+1][n+1];

            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < 3; j++) {
                    house[i][j] = in.nextInt();
                }
                Arrays.fill(dpFirst[i], MAX);
                Arrays.fill(dpSecond[i], MAX);
                Arrays.fill(dpThird[i], MAX);
            }

            if (n == 1) {
                out.print(Math.min(house[1][0], Math.min(house[1][1], house[1][2])));
                return;
            }
            dpFirst[2][1] = house[1][0] + house[2][1];
            dpFirst[2][2] = house[1][0] + house[2][2];
            for (int i = 3; i <= n; i++) {
                dpFirst[i][0] = Math.min(dpFirst[i][0], dpFirst[i-1][1] + house[i][0]);
                dpFirst[i][0] = Math.min(dpFirst[i][0], dpFirst[i-1][2] + house[i][0]);
                dpFirst[i][1] = Math.min(dpFirst[i][1], dpFirst[i-1][0] + house[i][1]);
                dpFirst[i][1] = Math.min(dpFirst[i][1], dpFirst[i-1][2] + house[i][1]);
                dpFirst[i][2] = Math.min(dpFirst[i][2], dpFirst[i-1][0] + house[i][2]);
                dpFirst[i][2] = Math.min(dpFirst[i][2], dpFirst[i-1][1] + house[i][2]);
            }
            int currentFirst = Math.min(dpFirst[n][1], dpFirst[n][2]);

            dpSecond[2][0] = house[1][1] + house[2][0];
            dpSecond[2][2] = house[1][1] + house[2][2];
            for (int i = 3; i <= n; i++) {
                dpSecond[i][0] = Math.min(dpSecond[i][0], dpSecond[i-1][1] + house[i][0]);
                dpSecond[i][0] = Math.min(dpSecond[i][0], dpSecond[i-1][2] + house[i][0]);
                dpSecond[i][1] = Math.min(dpSecond[i][1], dpSecond[i-1][0] + house[i][1]);
                dpSecond[i][1] = Math.min(dpSecond[i][1], dpSecond[i-1][2] + house[i][1]);
                dpSecond[i][2] = Math.min(dpSecond[i][2], dpSecond[i-1][0] + house[i][2]);
                dpSecond[i][2] = Math.min(dpSecond[i][2], dpSecond[i-1][1] + house[i][2]);
            }
            int currentSecond = Math.min(dpSecond[n][0], dpSecond[n][2]);

            dpThird[2][0] = house[1][2] + house[2][0];
            dpThird[2][1] = house[1][2] + house[2][1];
            for (int i = 3; i <= n; i++) {
                dpThird[i][0] = Math.min(dpThird[i][0], dpThird[i-1][1] + house[i][0]);
                dpThird[i][0] = Math.min(dpThird[i][0], dpThird[i-1][2] + house[i][0]);
                dpThird[i][1] = Math.min(dpThird[i][1], dpThird[i-1][0] + house[i][1]);
                dpThird[i][1] = Math.min(dpThird[i][1], dpThird[i-1][2] + house[i][1]);
                dpThird[i][2] = Math.min(dpThird[i][2], dpThird[i-1][0] + house[i][2]);
                dpThird[i][2] = Math.min(dpThird[i][2], dpThird[i-1][1] + house[i][2]);
            }
            int currentThird = Math.min(dpThird[n][0], dpThird[n][1]);
            out.print(Math.min(currentFirst, Math.min(currentSecond, currentThird)));
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
