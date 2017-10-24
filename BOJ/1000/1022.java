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
        int r1, r2, c1, c2, maxLen;
        StringBuilder sb = new StringBuilder();
        public void run(InputReader in, PrintWriter out) {
            r1 = in.nextInt();
            c1 = in.nextInt();
            r2 = in.nextInt();
            c2 = in.nextInt();

            int len1 = String.valueOf(getNum(r1, c1)).length();
            int len2 = String.valueOf(getNum(r1, c2)).length();
            int len3 = String.valueOf(getNum(r2, c1)).length();
            int len4 = String.valueOf(getNum(r2, c2)).length();
            maxLen = Math.max(Math.max(len1, len2), Math.max(len3, len4));

            for(int i = r1; i <= r2; i++) {
                for(int j = c1; j <= c2; j++) {
                    int currNum = getNum(i, j);
                    int currLen = maxLen - String.valueOf(currNum).length();
                    for(int k = 0; k < currLen; k++) {
                        sb.append(" ");
                    }
                    sb.append(currNum + " ");
                }
                if(i != r2) {
                    sb.append("\n");
                }
            }

            out.println(sb);
        }

        private int getNum(int x, int y) {
            if(x == 0 && y == 0) {
                return 1;
            }
            int result = 0;
            int len = Math.max(Math.abs(x), Math.abs(y));
            int start = len * (len-1) * 4 + 1;
            int line = len * 2;
            int cr1 = len * -1;
            int cr2 = len;
            int cc1 = len * -1;
            int cc2 = len;

            if(y == cc2 && x != cr2) {
                result = start + y - x;
            } else if(y != cc2 && x == cr1) {
                result = start + (line * 1) + (-1 * y - x);
            } else if(y == cc1 && x != cr1) {
                result = start + (line * 2) + x - y;
            } else if(y != cc1 && x == cr2) {
                result = start + (line * 3) + (x - (y * -1));
            }
            return result;
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
    }
}