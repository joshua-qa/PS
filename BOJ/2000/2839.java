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
        public void run(InputReader in, PrintWriter out) {
            int num = in.nextInt();
            int count = 0;

            if (num == 4 || num == 7) {
                count = -1;
            } else if (num % 5 == 0) {
                count = num / 5;
            } else if (num < 13 && num % 3 == 0) {
                count = num / 3;
            } else if (num > 10 && (num % 5 == 4 || num % 5 == 2)) {
                count = (num / 5) + 2;
            } else if (num > 10 && (num % 5 == 3 || num % 5 == 1)) {
                count = (num / 5) + 1;
            }

            out.print(count);
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