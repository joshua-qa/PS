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
        int ans, num;
        char c;
        public void run(InputReader in, PrintWriter out) {
            boolean numberFlag = false;
            boolean continueFlag = true;

            ans = in.nextInt();
            while(true) {
                if(!numberFlag) {
                    c = in.next().charAt(0);
                    if(c == '=') {
                        break;
                    }
                } else {
                    num = in.nextInt();
                    switch (c) {
                        case '+' :
                            ans += num;
                            break;
                        case '-' :
                            ans -= num;
                            break;
                        case '*' :
                            ans *= num;
                            break;
                        case '/' :
                            ans /= num;
                            break;
                    }
                }

                numberFlag = numberFlag ? false : true;
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