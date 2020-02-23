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
        int[] trace;
        List<Integer> lis = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            nums = new int[n];
            trace = new int[n+1];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
                int size = lis.size();
                if (size == 0 || lis.get(size-1) < nums[i]) {
                    lis.add(nums[i]);
                    trace[i+1] = size + 1;
                    continue;
                }
                int lowerBound = lowerBound(nums[i]);
                lis.set(lowerBound, nums[i]);
                trace[i+1] = lowerBound + 1;
            }
            int size = lis.size();
            while (size > 0) {
                if (trace[n] == size) {
                    stack.push(nums[n-1]);
                    size--;
                }
                n--;
            }

            out.write(lis.size() + "\n");
            while (!stack.isEmpty()) {
                out.write(stack.pop() + " ");
            }
            out.flush();
        }

        private int lowerBound(int value) {
            int size = lis.size();
            int start = 0;
            int end = size - 1;
            int mid = (start + end) / 2;
            while (start < end) {
                int midValue = lis.get(mid);
                if (midValue < value) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
                mid = (start + end) / 2;
            }
            return mid;
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
