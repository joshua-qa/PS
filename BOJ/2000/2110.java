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
        private int[] house;
        private int n, m, max, low, hi, end, mid;
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            m = in.nextInt();

            house = new int[n];
            for (int i = 0; i < n; i++) {
                house[i] = in.nextInt();
            }
            Arrays.sort(house);
            solve();
            out.print(max);
        }

        private void solve() {
            low = 1;
            hi = house[n-1] - house[0];
            end = house[n-1];

            while (low <= hi) {
                mid = (low + hi) / 2;
                boolean flag = true;
                int i = 1;

                for (int j = 1, prev = 0; i < m && j < n; j++) {
                    int current = house[prev] + mid;
                    if (current > end) {
                        flag = false;
                        break;
                    }
                    if (current <= house[j]) {
                        i++;
                        prev = j;
                    }
                }
                if (flag && i == m) {
                    max = Math.max(max, mid);
                    low = mid + 1;
                    continue;
                }
                hi = mid - 1;
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
