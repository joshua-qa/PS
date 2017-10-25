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
        int[] input;
        int[] D = new int[41];
        int len, curr;
        public void run(InputReader in, PrintWriter out) {
            String s = in.next();
            len = s.length();
            input = new int[len];
            for(int i = 0; i < len; i++) {
                input[i] = s.charAt(i) - '0';
            }

            D[1] = 1;
            D[2] = input[1] != 0 && (input[0] * 10 + input[1]) < 35 ? 2 : 1;

            for(int i = 3; i <= len; i++) {
                if(input[i-1] != 0) {
                    D[i] = D[i - 1];
                }
                curr = input[i-2] * 10 + input[i-1];
                if(curr > 9 && curr < 35) {
                    D[i] += D[i-2];
                }
            }

            out.print(D[len]);
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