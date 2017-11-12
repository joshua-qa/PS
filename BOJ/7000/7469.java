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

    static class kthArray implements Comparable<kthArray> {
        int index;
        int num;

        public kthArray(int i, int n) {
            this.index = i;
            this.num = n;
        }

        @Override
        public int compareTo(kthArray o) {
            return this.num - o.num;
        }
    }

    static class Task {
        int n, m, a, b, kth;
        kthArray[] nums;
        StringBuilder sb = new StringBuilder();
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            m = in.nextInt();
            nums = new kthArray[n];

            for(int i = 0; i < n; i++) {
                nums[i] = new kthArray(i+1, in.nextInt());
            }

            Arrays.sort(nums);

            for(int i = 0; i < m; i++) {
                a = in.nextInt();
                b = in.nextInt();
                kth = in.nextInt();

                sb.append(query(a, b, kth) + "\n");
            }

            out.print(sb);
        }

        private int query(int start, int end, int kth) {
            int index = 0;
            int count = 0;
            int curr = 0;

            while(count < kth) {
                index++;
                curr = nums[index-1].index;
                if(curr >= start && curr <= end) {
                    count++;
                }
            }

            return nums[index-1].num;
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