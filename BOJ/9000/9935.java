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

    static class Text {
        int index;
        boolean flag;
        char c;

        public Text(int index, boolean flag, char c) {
            this.index = index;
            this.flag = flag;
            this.c = c;
        }
    }

    static class Task {
        int end;
        int[] bombIndex = new int[128];
        StringBuilder sb = new StringBuilder();
        Stack<Text> stack = new Stack<>();
        public void run(InputReader in, PrintWriter out) {
            Arrays.fill(bombIndex, -1);
            char[] ca = in.next().toCharArray();
            char[] bombText = in.next().toCharArray();
            end = bombText.length;

            for(int i = 0; i < bombText.length; i++) {
                bombIndex[bombText[i]] = i+1;
            }

            for(char c : ca) {
                int bIndex = bombIndex[c];
                if(stack.isEmpty()) {
                    if(bIndex == 1) {
                        if(bIndex != end) {
                            stack.push(new Text(bIndex, true, c));
                        }
                    } else {
                        stack.push(new Text(bIndex, false, c));
                    }
                    continue;
                }

                if(bIndex == 1) {
                    if(bIndex != end) {
                        stack.push(new Text(bIndex, true, c));
                    }
                } else if(bIndex == -1) {
                    stack.push(new Text(bIndex, false, c));
                } else if(bIndex == end) {
                    Text peek = stack.peek();
                    if(peek.index == bIndex-1 && peek.flag) {
                        for(int i = 0; i < bIndex-1; i++) {
                            stack.pop();
                        }
                    } else {
                        stack.push(new Text(bIndex, false, c));
                    }
                } else {
                    Text peek = stack.peek();
                    if(peek.index == bIndex-1 && peek.flag) {
                        stack.push(new Text(bIndex, true, c));
                    } else {
                        stack.push(new Text(bIndex, false, c));
                    }
                }
            }

            if(stack.isEmpty()) {
                sb.append("FRULA");
            } else {
                while(!stack.isEmpty()) {
                    Text popValue = stack.pop();

                    sb.append(popValue.c);
                }
                sb.reverse();

                int fin = sb.indexOf(String.valueOf(bombText));
                if(fin > -1) {
                    sb.delete(fin, fin+bombText.length);
                }
            }

            if(sb.length() == 0) {
                sb.append("FRULA");
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

    }
}