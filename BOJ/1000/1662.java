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
            char[] ca = in.next().trim().toCharArray();

            int len = 0;
            Stack<Integer> stack = new Stack<>();

            for(int i = 0; i < ca.length; i++) {
                if(ca[i] == '(') {
                    stack.push(-1);
                } else if(ca[i] == ')') {
                    int curr = 0;
                    while(stack.peek() != -1) {
                        int popValue = stack.pop();
                        if(popValue < 10) {
                            curr++;
                        } else {
                            curr += (popValue - 10);
                        }
                    }

                    stack.pop();
                    curr *= stack.pop();
                    stack.push(curr + 10);
                } else {
                    stack.push(ca[i] - '0');
                }
            }

            while(!stack.isEmpty()) {
                if(stack.peek() < 10) {
                    len++;
                    stack.pop();
                } else {
                    len += (stack.pop() - 10);
                }
            }

            out.print(len);
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