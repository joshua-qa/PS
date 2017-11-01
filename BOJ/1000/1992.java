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
        char[][] map;
        int n;
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();

            map = new char[n][n];

            for(int i = 0; i < n; i++) {
                map[i] = in.next().toCharArray();
            }

            out.print(solve(0, 0, n));
        }

        private String solve(int x, int y, int size) {
            if(size == 1) {
                return map[x][y] == '1' ? "1" : "0";
            }

            String returnString = solve(x, y, size/2) +
                    solve(x, y + (size/2), size/2) +
                    solve(x + (size/2), y, size/2) +
                    solve(x + (size/2), y + (size/2), size/2);

            if(returnString.equals("0000")) {
                return "0";
            } else if(returnString.equals("1111")) {
                return "1";
            } else {
                return "(" + returnString + ")";
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