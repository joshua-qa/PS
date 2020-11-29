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
        private int n;
        private char[][] starMap;
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            starMap = new char[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(starMap[i], ' ');
            }
            solve(0, 0, n);
            for (int i = 0; i < n; i++) {
                out.write(starMap[i]);
                out.write("\n");
            }
        }

        private void solve(int x, int y, int size) {
            if (size == 3) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (i == 1 && j == 1) {
                            continue;
                        }
                        starMap[x+i][y+j] = '*';
                    }
                }
                return;
            }
            int currentSize = size / 3;

            solve(x, y, currentSize);
            solve(x, y + currentSize, currentSize);
            solve(x, y + (currentSize * 2), currentSize);
            solve(x + currentSize, y, currentSize);
            solve(x + currentSize, y + (currentSize * 2), currentSize);
            solve(x + (currentSize * 2), y, currentSize);
            solve(x + (currentSize * 2), y + currentSize, currentSize);
            solve(x + (currentSize * 2), y + (currentSize * 2), currentSize);
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
