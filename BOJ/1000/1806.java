import java.io.*;
import java.util.StringTokenizer;

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
        int n, m, s, e, sum, min;
        int[] nums;
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            m = in.nextInt();
            nums = new int[n];

            for(int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }

            min = Integer.MAX_VALUE;
            s = 0;
            e = 1;
            sum = nums[0];
            if(sum >= m) {
                min = 1;
            }

            while(e < n || s < n) {
                if(sum < m && e < n) {
                    sum += nums[e];
                    e++;
                } else {
                    sum -= nums[s];
                    s++;
                }

                if(sum >= m && min > (e-s)) {
                    min = e-s;
                }
            }

            out.print(min == Integer.MAX_VALUE ? 0 : min);
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

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (Exception e) {
                return "";
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