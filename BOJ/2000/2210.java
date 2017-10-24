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
        int n = 5;
        int[][] map = new int[5][5];
        int[] directionX = {-1, 0, 0, 1};
        int[] directionY = {0, -1, 1, 0};
        HashSet<Integer> numSet = new HashSet<>();
        public void run(InputReader in, PrintWriter out) {
            for(int i = 0; i < map.length; i++) {
                for(int j = 0; j < map[0].length; j++) {
                    map[i][j] = in.nextInt();
                }
            }

            for(int i = 0; i < map.length; i++) {
                for(int j = 0; j < map[0].length; j++) {
                    find(i, j, map[i][j], 1);
                }
            }

            out.print(numSet.size());
        }

        private void find(int x, int y, int currNum, int size) {
            if(size == 6) {
                numSet.add(currNum);
                return;
            }

            for(int i = 0; i < directionX.length; i++) {
                int currX = x + directionX[i];
                int currY = y + directionY[i];
                if(currX < 0 || currX >= n || currY < 0 || currY >= n) {
                    continue;
                }

                find(currX, currY, (currNum * 10) + map[currX][currY], size+1);
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