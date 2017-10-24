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
        int n, m, ans;
        int[][] map, resultMap;
        final int ROTATE_SIZE = 3;
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            m = in.nextInt();
            map = new int[n][m];
            resultMap = new int[n][m];

            for(int i = 0; i < n; i++) {
                char[] ca = in.next().toCharArray();
                for(int j = 0; j < m; j++) {
                    map[i][j] = ca[j] - '0';
                }
            }

            for(int i = 0; i < n; i++) {
                char[] ca = in.next().toCharArray();
                for(int j = 0; j < m; j++) {
                    resultMap[i][j] = ca[j] - '0';
                }
            }

            for(int i = 0; i <= n - ROTATE_SIZE; i++) {
                for(int j = 0; j <= m - ROTATE_SIZE; j++) {
                    if(map[i][j] == resultMap[i][j]) {
                        continue;
                    } else {
                        rorateArray(i, j);
                        ans++;
                    }
                }
            }

            boolean flag = true;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(map[i][j] != resultMap[i][j]) {
                        ans = -1;
                        flag = false;
                        break;
                    }
                }
                if(!flag) {
                    break;
                }
            }

            out.println(ans);
        }

        private void rorateArray(int x, int y) {
            for(int i = x; i < x+3; i++) {
                for(int j = y; j < y+3; j++) {
                    map[i][j] = map[i][j] == 0 ? 1 : 0;
                }
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