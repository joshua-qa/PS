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
        int n, len;
        long ans;
        long[] tree;
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            len = (2 << n);
            tree = new long[len];
            for(int i = 2; i < len; i++) {
                tree[i] = in.nextInt();
            }

            balance(len / 4, len / 2 - 1);

            for(int i = 0; i < len; i++) {
                ans += tree[i];
            }
            out.print(ans);
        }

        private long getWeight(int node) {
            if(node*2 + 1 >= len) {
                return tree[node];
            }

            return tree[node] + getWeight(node*2);
        }

        private void balance(int start, int end) {
            for(int i = start; i <= end; i++) {
                long getLeft = getWeight(i*2);
                long getRight = getWeight(i*2+1);

                if(getLeft > getRight) {
                    tree[i * 2 + 1] += (getLeft - getRight);
                } else if(getLeft < getRight) {
                    tree[i * 2] += (getRight - getLeft);
                }
            }

            if(start != end) {
                balance(start / 2, start - 1);
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

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}