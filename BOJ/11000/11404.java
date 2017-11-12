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
        final int INF = 987654321;
        int n, m, x, y, dist;
        int[][] map;
        StringBuilder sb = new StringBuilder();
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            m = in.nextInt();
            map = new int[n+1][n+1];

            for(int i = 0; i <= n; i++) {
                Arrays.fill(map[i], INF);
                map[i][i] = 0;
            }

            for(int i = 0; i < m; i++) {
                x = in.nextInt();
                y = in.nextInt();
                dist = in.nextInt();

                if(map[x][y] > dist) {
                    map[x][y] = dist;
                }
            }

            for(int k = 1; k <= n; k++) {
                for(int i = 1; i <= n; i++) {
                    for(int j = 1; j <= n; j++) {
                        if(map[i][j] > map[i][k] + map[k][j]) {
                            map[i][j] = map[i][k] + map[k][j];
                        }
                    }
                }
            }

            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
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

        public String nextLine() {
            String s;
            try {
                s = reader.readLine();
            } catch (Exception e) {
                return "-1";
            }
            if(s == null || s.equals("")) {
                return "-1";
            }

            return s;
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