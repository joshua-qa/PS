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
            String x = in.next();
            String y = in.next();
            int xLen = x.length();
            int yLen = y.length();

            if(xLen > yLen) {
                for(int i = 0; i < xLen-yLen; i++) {
                    y = "0" + y;
                }
            } else if(yLen > xLen) {
                for(int i = 0; i < yLen-xLen; i++) {
                    x = "0" + x;
                }
            }

            char[] xca = x.toCharArray();
            char[] yca = y.toCharArray();

            int next = 0;
            int index = xca.length;
            StringBuilder sb = new StringBuilder();
            while(index-- > 0) {
                int currX = xca[index] - '0';
                int currY = yca[index] - '0';
                int curr = currX + currY + next;
                switch (curr) {
                    case 0 :
                        sb.append(0);
                        next = 0;
                        continue;
                    case 1 :
                        sb.append(1);
                        next = 0;
                        continue;
                    case 2 :
                        sb.append(0);
                        next = 1;
                        continue;
                    case 3 :
                        sb.append(1);
                        next = 1;
                        continue;
                }
            }
            if(next == 1) {
                sb.append(1);
            }

            sb.reverse();
            if(sb.length() > 1) {
                while (sb.length() > 1 && sb.substring(0, 1).equals("0")) {
                    sb.delete(0, 1);
                }
            }

            if(sb.length() == 0) {
                sb.append("0");
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

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}