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
        int n, m, ans;
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            m = in.nextInt();
            long len = 0;

            for(int i = 1, j = 1; i < 10; i++, j *= 10) {
                int curr = i * j * 9;
                int max = j * 10 - 1;

                if(n > max) {
                    len += (long)curr;
                } else if(i == max) {
                    len += (long)curr;
                    break;
                } else {
                    len += (long)(curr - ((max - n) * i));
                    break;
                }
            }

            if(len < m) {
                ans = -1;
            } else {

                for(int i = 1, j = 1, startNum = 1; i < 10; i++, j *= 10, startNum *= 10) {
                    int curr = i * j * 9;
                    if(m <= curr) {
                        int numIndex = (m % i == 0) ? (m / i) : ((m / i) + 1);
                        char[] realNum = String.valueOf(startNum + numIndex - 1).toCharArray();
                        int cipher = m - ((numIndex - 1) * i);

                        ans = realNum[cipher - 1] - '0';

                        break;
                    } else {
                        m -= curr;
                        len -= curr;
                    }
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

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}