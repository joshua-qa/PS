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
            int n = in.nextInt();

            char[] ca = String.valueOf(n).toCharArray();

            boolean flag = false;

            if(ca.length > 1) {
                int mul = 1;
                for(int i = 0; i < ca.length-1; i++) {
                    mul *= (ca[i] - '0');

                    int temp = 1;
                    for(int j = i+1; j < ca.length; j++) {
                        temp *= (ca[j] - '0');
                    }

                    if(mul == temp) {
                        flag = true;
                        break;
                    }
                }
            }

            out.print(flag ? "YES" : "NO");
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