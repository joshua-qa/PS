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
        int len, currLen, max;
        boolean flag;
        public void run(InputReader in, PrintWriter out) {
            char[] str = in.next().toCharArray();
            len = str.length;

            for(int i = len-1; i >= 0; i--) {
                currLen = len-i;
                flag = true;
                for(int j = 0; j < currLen / 2; j++) {
                    if(str[i+j] != str[len-j-1]) {
                        flag = false;
                        break;
                    }
                }

                if(flag) {
                    max = currLen;
                }
            }

            if(max == len) {
                out.print(len);
            } else {
                out.print(len*2 - max);
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