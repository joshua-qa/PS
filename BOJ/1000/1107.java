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
        int n, m, sub, result;
        boolean[] numberPad = new boolean[10];
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            m = in.nextInt();

            for(int i = 0; i < m; i++) {
                numberPad[in.nextInt()] = true;
            }

            result = abs(n - 100);

            for(int i = 0; i <= 1000000; i++) {
                if(!judge(i)) {
                    continue;
                }

                sub = abs(i - n) + length(i);

                if(result > sub) {
                    result = sub;
                }
            }

            out.print(result);
        }

        private int abs(int num) {
            return num > 0 ? num : -num;
        }

        private int length(int num) {
            if(num == 0) {
                return 1;
            }
            int length = 0;
            long temp = 1;
            while (temp <= num) {
                length++;
                temp *= 10;
            }
            return length;
        }

        private boolean judge(int num) {
            int div = num;
            int mod = 0;
            while(div >= 10) {
                mod = div % 10;
                div = div / 10;
                if(numberPad[mod]) {
                    return false;
                }
            }
            return !numberPad[div];
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