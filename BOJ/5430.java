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
        int n, count;
        boolean flagR, flag;
        Deque<String> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder(200000);
        StringTokenizer st;
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();

            while(n-- > 0) {
                char[] commands = in.next().toCharArray();

                count = in.nextInt();
                if(count > 0) {
                    String s = in.next();
                    s = s.substring(1, s.length()-1);
                    st = new StringTokenizer(s, ",");

                    while(st.hasMoreTokens()) {
                        deque.addLast(st.nextToken());
                    }
                } else {
                    in.next();
                }

                flag = true;
                for(char c : commands) {
                    switch (c) {
                        case 'R':
                            flagR = flagR ? false : true;
                            continue;
                        case 'D':
                            if(deque.isEmpty()) {
                                flag = false;
                                break;
                            }
                            if(flagR) {
                                deque.removeLast();
                            } else {
                                deque.removeFirst();
                            }
                            continue;
                    }

                    if(!flag) {
                        break;
                    }
                }

                if(!flag) {
                    sb.append("error\n");
                    deque.clear();
                } else {
                    print(flagR);
                }
                flagR = false;
            }

            out.print(sb);
        }

        private void print(boolean reverse) {
            sb.append("[");
            if(!deque.isEmpty()) {
                if (reverse) {
                    while (deque.size() > 1) {
                        sb.append(deque.removeLast()).append(",");
                    }
                    sb.append(deque.removeLast());
                } else {
                    while (deque.size() > 1) {
                        sb.append(deque.removeFirst()).append(",");
                    }
                    sb.append(deque.removeFirst());
                }
            }
            sb.append("]\n");
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