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
        int n, k, l, m;
        int[] a, b, c;
        boolean flag;
        StringBuilder sb = new StringBuilder();
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();

            while(n-- > 0) {
                k = in.nextInt();
                a = new int[k];
                for (int i = 0; i < a.length; i++) {
                    a[i] = in.nextInt();
                }
                l = in.nextInt();
                b = new int[l];
                for (int i = 0; i < b.length; i++) {
                    b[i] = in.nextInt();
                }
                m = in.nextInt();
                c = new int[m];
                for (int i = 0; i < c.length; i++) {
                    c[i] = in.nextInt();
                }

                sb.append(solve()).append("\n");
            }

            out.print(sb);
        }

        private int solve() {
            int res = 0;
            HashSet<Integer> ansList = new HashSet<>();
            for(int i : a) {
                for(int j : b) {
                    for(int k : c) {
                        if(ansList.contains(i+j+k)) {
                            continue;
                        }
                        char[] ca = String.valueOf(i+j+k).toCharArray();
                        flag = true;
                        for(char c : ca) {
                            if(c != 53 && c!= 56) {
                                flag = false;
                                break;
                            }
                        }

                        if(flag) {
                            res++;
                            ansList.add(i+j+k);
                        }
                    }
                }
            }
            return res;
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(String fileName) {
            try {
                reader = new BufferedReader(new FileReader(fileName));
                tokenizer = null;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

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

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}