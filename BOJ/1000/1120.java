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
        int ans = Integer.MAX_VALUE;
        public void run(InputReader in, PrintWriter out) {
            String a = in.next();
            String b = in.next();

            char[] bCharArray = b.toCharArray();
            int sub = b.length() - a.length();

            for(int i = 0; i <= sub; i++) {
                char[] newA = (b.substring(0, i) + a + b.substring(b.length() - sub + i, b.length())).toCharArray();
                int curr = 0;
                for(int j = 0; j < bCharArray.length; j++) {
                    if(newA[j] != bCharArray[j]) {
                        curr++;
                    }
                }

                if(ans > curr) {
                    ans = curr;
                }
            }

            out.print(ans);
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