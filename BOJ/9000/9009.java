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
        int[] fibo = new int[45];
        StringBuilder sb = new StringBuilder();
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();

            fibo[0] = 0;
            fibo[1] = 1;

            for(int i = 2; i < fibo.length; i++) {
                fibo[i] = fibo[i-2] + fibo[i-1];
            }

            for(int i = 0; i < n; i++) {
                solve(in.nextInt());
            }

            out.print(sb);
        }

        private void solve(int num) {
            ArrayList<Integer> fiboList = new ArrayList<>();
            for(int i = fibo.length-1; i >= 0; i--) {
                if(num == 0) {
                    break;
                }
                if(num < fibo[i]) {
                    continue;
                } else {
                    num -= fibo[i];
                    fiboList.add(fibo[i]);
                }
            }

            for(int i = fiboList.size()-1; i >= 0; i--) {
                sb.append(fiboList.get(i) + " ");
            }

            sb.append("\n");
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
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
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