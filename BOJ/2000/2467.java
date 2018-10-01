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
        int n, left, right, min = Integer.MAX_VALUE;
        int[] nums;
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();

            nums = new int[n];
            for(int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }

            getMin();

            out.print(left + " " + right);
        }

        private void getMin() {
            int start = 0;
            int end = n-1;

            while(start < end) {
                int curr = Math.abs(nums[start] + nums[end]);

                if(min > curr) {
                    min = curr;
                    left = nums[start];
                    right = nums[end];
                }

                if(Math.abs(nums[start+1] + nums[end]) > Math.abs(nums[start] + nums[end-1])) {
                    end--;
                } else {
                    start++;
                }
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