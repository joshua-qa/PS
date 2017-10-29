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
            char[] ca = in.next().toCharArray();
            int[] count = new int[10];
            long sum = 0;

            for(char c : ca) {
                count[c - '0']++;
                sum += (c - '0');
            }

            if(sum % 3 != 0 || count[0] == 0) {
                out.print("-1");
            } else {
                StringBuilder sb = new StringBuilder(ca.length);
                for(int i = 9; i >= 0; i--) {
                    while(count[i]-- > 0) {
                        sb.append(i);
                    }
                }
                out.print(sb);
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