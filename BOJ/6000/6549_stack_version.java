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
        int n;
        StringBuilder sb = new StringBuilder();
        public void run(InputReader in, PrintWriter out) {
            while(true) {
                n = in.nextInt();
                if(n == 0) {
                    break;
                }

                long[] histogram = new long[n];
                for(int i = 0; i < n; i++) {
                    histogram[i] = in.nextInt();
                }

                sb.append(getMaxArea(n, histogram)).append("\n");
            }
            out.print(sb);
        }

        private long getMaxArea(int size, long[] histogram) {
            Stack<Integer> stack = new Stack<>();
            long answer = 0;

            stack.push(0);

            for(int i = 1; i < size; i++) {
                if(histogram[stack.peek()] <= histogram[i]) {
                    stack.push(i);
                    continue;
                }

                while(!stack.isEmpty() && histogram[stack.peek()] > histogram[i]) {
                    int top = stack.pop();
                    int width = 0;

                    if(stack.isEmpty()) {
                        width = i;
                    } else {
                        width = i - stack.peek() - 1;
                    }
                    long height = histogram[top];

                    if((long)width * height > answer) {
                        answer = (long)width * height;
                    }
                }
                stack.push(i);
            }

            while(!stack.isEmpty()) {
                int top = stack.pop();
                int width = 0;
                if(stack.isEmpty()) {
                    width = size;
                } else {
                    width = size - stack.peek() - 1;
                }
                long height = histogram[top];

                if((long)width * height > answer) {
                    answer = (long)width * height;
                }
            }

            return answer;
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