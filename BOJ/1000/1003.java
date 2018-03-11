import java.io.*;
import java.util.StringTokenizer;

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
        int n, m;
        int[][] d = new int[41][2];
        StringBuilder sb = new StringBuilder();
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();

            d[0][0] = 1;
            d[0][1] = 0;
            d[1][0] = 0;
            d[1][1] = 1;
            for(int i = 2; i <= 40; i++) {
                d[i][0] = d[i-1][0] + d[i-2][0];
                d[i][1] = d[i-1][1] + d[i-2][1];
            }

            for(int i = 0; i < n; i++) {
                m = in.nextInt();
                sb.append(d[m][0]).append(" ").append(d[m][1]).append("\n");
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

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (Exception e) {
                return "";
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