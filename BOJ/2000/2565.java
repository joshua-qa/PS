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
        int n, x, y, result;
        Line[] lines;
        int[] dp;
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            lines = new Line[n];
            dp = new int[n];
            for (int i = 0; i < n; i++) {
                x = in.nextInt();
                y = in.nextInt();
                lines[i] = new Line(x, y);
            }
            Arrays.sort(lines);
            for (int i = 0; i < n; i++) {
                if (dp[i] == 0) {
                    dp[i] = 1;
                }
                for (int j = 0; j < i; j++) {
                    if (lines[i].y > lines[j].y) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                result = Math.max(result, dp[i]);
            }
            out.println(n - result);
        }
    }

    static class Line implements Comparable<Line> {
        int x;
        int y;

        public Line(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Line o) {
            return this.x - o.x;
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
