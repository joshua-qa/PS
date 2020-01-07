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
        private int n, m, result;
        private int[] cards;
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            m = in.nextInt();
            cards = new int[n];
            for (int i = 0; i < n; i++) {
                cards[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                for (int j = i+1; j < n; j++) {
                    if (i == j) {
                        continue;
                    }
                    for (int k = j+1; k < n; k++) {
                        if (j == k || k == i) {
                            continue;
                        }
                        if (judge(cards[i], cards[j], cards[k])) {
                            result = Math.max(result, cards[i] + cards[j] + cards[k]);
                        }
                    }
                }
            }
            out.print(result);
        }

        private boolean judge (int x, int y, int z) {
            return x+y+z <= m;
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
