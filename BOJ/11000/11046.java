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
        int n, m, left, right, mid, length;
        int[] nums, palindrome;
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            length = n * 2 + 1;
            nums = new int[length];
            palindrome = new int[length];
            for (int i = 0; i < length; i++) {
                if ((i & 1) == 0) {
                    nums[i] = -1;
                    continue;
                }
                nums[i] = in.nextInt();
            }
            manacher();
            m = in.nextInt();
            for (int i = 0; i < m; i++) {
                left = in.nextInt() * 2 - 1; // 1 == 1 * 2 - 1 = 1
                right = in.nextInt() * 2 - 1; // 3 == 3 * 2 - 1 = 5
                mid = (left + right) / 2;
                if (mid - palindrome[mid] <= left && mid + palindrome[mid] >= right) {
                    out.write("1\n");
                } else {
                    out.write("0\n");
                }
            }
            out.flush();
        }

        private void manacher() {
            int r = 0, p = 0;
            for (int i = 0; i < palindrome.length; i++) {
                if (r >= i) {
                    palindrome[i] = Math.min(palindrome[2 * p - i], r - i);
                }
                while (i - palindrome[i] - 1 >= 0 && i + palindrome[i] + 1 < length && nums[i - palindrome[i] - 1] == nums[i + palindrome[i] + 1]) {
                    palindrome[i]++;
                }
                if (i + palindrome[i] > r) {
                    r = i + palindrome[i];
                    p = i;
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
