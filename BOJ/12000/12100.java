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
        int n, front, frontIndex, result;
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            int[][] map = new int[n][n];

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    map[i][j] = in.nextInt();
                }
            }

            dfs(0, map);

            out.print(result);
        }

        private void dfs(int count, int[][] map) {
            if(count == 5) {
                getMaxValue(map);
                return;
            }

            for(int i = 0; i < 4; i++) {
                map = rotate(map);
                int[][] newMap = left(map);
                dfs(count + 1, newMap);
            }
        }

        private void getMaxValue(int[][] map) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(map[i][j] != 0 && result < map[i][j]) {
                        result = map[i][j];
                    }
                }
            }
        }

        private int[][] left(int[][] map) {
            int[][] newMap = new int[n][n];
            for(int i = 0; i < n; i++) {
                System.arraycopy(map[i], 0, newMap[i], 0, n);
                front = newMap[i][0];
                frontIndex = 0;
                for(int j = 1; j < n; j++) {
                    if(newMap[i][j] == 0) {
                        continue;
                    } else if(newMap[i][frontIndex] == 0) {
                        newMap[i][frontIndex] = newMap[i][j];
                        front = newMap[i][j];
                        newMap[i][j] = 0;
                        continue;
                    }
                    if(front == newMap[i][j]) {
                        newMap[i][frontIndex] *= 2;
                        front = 0;
                        newMap[i][j] = 0;
                    } else {
                        if(++frontIndex != j) {
                            newMap[i][frontIndex] = newMap[i][j];
                            newMap[i][j] = 0;
                        }
                        front = newMap[i][frontIndex];
                    }
                }
            }

            return newMap;
        }

        private int[][] rotate(int[][] map) {
            int[][] newMap = new int[n][n];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    newMap[n-j-1][i] = map[i][j];
                }
            }
            return newMap;
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