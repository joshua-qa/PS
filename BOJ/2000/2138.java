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
        int n, count, count2;
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            char[] ca = in.next().toCharArray();
            char[] ca2 = Arrays.copyOf(ca, ca.length);
            char[] target = in.next().toCharArray();

            if(Arrays.equals(ca, target)) {
                out.print(0);
            } else {
                change(0, ca);
                count++;
                for (int i = 1; i < n; i++) {
                    if (ca[i - 1] == target[i - 1]) {
                        continue;
                    } else {
                        change(i, ca);
                        count++;
                    }
                }

                for (int i = 1; i < n; i++) {
                    if (ca2[i - 1] == target[i - 1]) {
                        continue;
                    } else {
                        change(i, ca2);
                        count2++;
                    }
                }

                if (Arrays.equals(ca, target)) {
                    out.print(count);
                } else if (Arrays.equals(ca2, target)) {
                    out.print(count2);
                } else {
                    out.print(-1);
                }
            }
        }

        private void change(int curr, char[] states) {
            if(curr-1 >= 0) {
                states[curr-1] = (states[curr-1] == '0') ? '1' : '0';
            }
            states[curr] = (states[curr] == '0') ? '1' : '0';
            if(curr+1 < n) {
                states[curr+1] = (states[curr+1] == '0') ? '1' : '0';
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