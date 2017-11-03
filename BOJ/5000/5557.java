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
        int[] nums;
        long[][] D;
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            nums = new int[n];
            D = new long[n+1][21];

            for(int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }

            D[0][nums[0]] = 1;

            for(int i = 1; i < n-1; i++) {
                for(int j = 0; j <= 20; j++) {
                    if(j - nums[i] >= 0) {
                        if(D[i-1][j] != 0) {
                            D[i][j - nums[i]] += D[i - 1][j];
                        }
                    }
                    if(j + nums[i] <= 20) {
                        if(D[i-1][j] != 0) {
                            D[i][j + nums[i]] += D[i - 1][j];
                        }
                    }
                }
            }

            out.print(D[n-2][nums[n-1]]);
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