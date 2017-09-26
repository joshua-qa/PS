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
        long min, max, start;
        int arraySize, ans, index;
        long[] powArray = new long[78498];
        boolean[] prime = new boolean[1000001];
        boolean[] nums = new boolean[1001000];
        public void run(InputReader in, PrintWriter out) {
            min = in.nextLong();
            max = in.nextLong();

            for(int i = 2; i < 1000001; i++) {
                if(prime[i]) {
                    continue;
                }
                powArray[index++] = (long)i*(long)i;
                for(int j = i*2; j < 1000001; j += i) {
                    if(prime[j]) {
                        continue;
                    }
                    prime[j] = true;
                }
            }

            arraySize = (int)(max-min) + 1;
            ans = arraySize;

            for(long pow : powArray) {
                if(pow > max) {
                    break;
                }

                long mod = min % pow;
                if(mod == 0) {
                    start = min;
                } else {
                    start = min - mod + pow;
                }

                for(long j = start; j <= max; j += pow) {
                    int curr = (int)(j-min) + 1;
                    if(nums[curr]) {
                        continue;
                    } else {
                        nums[curr] = true;
                        ans--;
                    }
                }
            }

            out.println(ans);
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