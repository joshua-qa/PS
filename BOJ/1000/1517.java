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
        long count;
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            nums = new int[n];

            for(int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }

            mergeSort(0, n-1);

            out.print(count);
        }

        private void mergeSort(int start, int end) {
            if(start == end) {
                return;
            }
            int mid = (start + end) / 2;
            mergeSort(start, mid);
            mergeSort(mid+1, end);
            merge(start, end);
        }

        private void merge(int start, int end) {
            int[] temp = new int[end-start+1];
            int mid = (start + end) / 2;
            int a = start, b = mid+1, k = 0;

            while(a <= mid && b <= end) {
                if(nums[a] <= nums[b]) {
                    temp[k++] = nums[a++];
                } else {
                    count += (mid - a + 1);
                    temp[k++] = nums[b++];
                }
            }
            while(a <= mid) {
                temp[k++] = nums[a++];
            }
            while(b <= end) {
                temp[k++] = nums[b++];
            }
            for(int i = start; i <= end; i++) {
                nums[i] = temp[i-start];
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