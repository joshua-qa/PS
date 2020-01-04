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
        private int n, m, left, right, treeSize;
        private int[][] tree;
        private int[] nums;
        public static final int MAX = Integer.MAX_VALUE;
        public static final int MIN = Integer.MIN_VALUE;
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            m = in.nextInt();
            treeSize = getTreeSize();
            tree = new int[treeSize][2];
            nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }
            init();
            for (int i = 0; i < m; i++) {
                left = in.nextInt();
                right = in.nextInt();
                int[] result = query(left, right);
                out.write(result[0] + " " + result[1] + "\n");
            }
            out.flush();
        }

        private int getTreeSize() {
            return (int)Math.pow(2, (int)(Math.log(n) / Math.log(2)) + 2);
        }

        private void init() {
            for (int i = treeSize / 2, j = 0; i < treeSize; i++, j++) {
                if (j < nums.length) {
                    tree[i][0] = tree[i][1] = nums[j];
                } else {
                    tree[i][0] = MAX;
                    tree[i][1] = MIN;
                }
            }

            for (int i = treeSize / 2 - 1; i >= 1; i--) {
                tree[i][0] = Math.min(tree[i*2][0], tree[i*2+1][0]);
                tree[i][1] = Math.max(tree[i*2][1], tree[i*2+1][1]);
            }
        }

        private int[] query(int startIndex, int endIndex) {
            return search(startIndex, endIndex, 1, 1, treeSize/2);
        }

        private int[] search(int left, int right, int node, int nodeStart, int nodeEnd) {
            if (left > nodeEnd || right < nodeStart) {
                return new int[]{MAX, MIN};
            }
            if (left <= nodeStart && right >= nodeEnd) {
                return new int[]{tree[node][0], tree[node][1]};
            }
            int mid = (nodeStart + nodeEnd) / 2;
            int[] leftResult = search(left, right, node*2, nodeStart, mid);
            int[] rightResult = search(left, right, node*2+1, mid+1, nodeEnd);
            return new int[]{Math.min(leftResult[0], rightResult[0]), Math.max(leftResult[1], rightResult[1])};
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
