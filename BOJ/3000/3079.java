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
        int n, m;
        long min, mid, max;
        int[] desk;
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            m = in.nextInt();

            desk = new int[n];

            for(int i = 0; i < n; i++) {
                desk[i] = in.nextInt();
            }

            max = (long)1e18;

            while(min < max) {
                mid = (min + max) / 2;

                int count = m;
                int i = 0;

                while(count > 0 && i < n) {
                    if(count >= (mid / desk[i])) {
                        count -= mid / desk[i];
                        i++;
                    } else {
                        count = 0;
                    }
                }

                if(count > 0) {
                    min = mid+1;
                } else {
                    max = mid;
                }
            }

            out.print(max);
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