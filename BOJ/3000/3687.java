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
        int n, count;
        long[] min = new long[101];
        StringBuilder sb = new StringBuilder();
        public void run(InputReader in, PrintWriter out) {
            Arrays.fill(min, Long.MAX_VALUE);
            setMin();

            count = in.nextInt();

            for (int i = 0; i < count; i++) {
                n = in.nextInt();
                sb.append(min[n]).append(" ").append(getMax(n)).append("\n");
            }

            out.print(sb);
        }

        private String getMax(int num) {
            StringBuilder max = new StringBuilder();
            int length = num / 2;
            if ((num & 1) == 1) {
                max.append("7");
            } else {
                max.append("1");
            }

            for (int i = 0; i < length - 1; i++) {
                max.append("1");
            }
            return max.toString();
        }

        private void setMin() {
            min[2] = 1;
            min[3] = 7;
            min[4] = 4;
            min[5] = 2;
            min[6] = 6; // 다른 숫자 뒤에 올 때는 0
            min[7] = 8;
            min[8] = 10;
            String[] add = {"1", "7", "4", "2", "0", "8"};

            for (int i = 9; i <= 100; i++) {
                for (int j = 2; j <= 7; j++) {
                    String curr = min[i - j] + add[j-2];
                    min[i] = Math.min(min[i], Long.parseLong(curr));
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