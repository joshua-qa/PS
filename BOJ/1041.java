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
        int a, b, c, d, e, f;
        long n, ans;
        public void run(InputReader in, PrintWriter out) {
            n = in.nextLong();

            a = in.nextInt();
            b = in.nextInt();
            c = in.nextInt();
            d = in.nextInt();
            e = in.nextInt();
            f = in.nextInt();

            ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(a, b, c, d, e, f));
            Collections.sort(nums);
            if(n != 1) {
                long count = (n * n * 2) + ((n-2) * (n-2)) + ((n-2) * n * 2);

                ArrayList<Integer> triple = new ArrayList<>(Arrays.asList(a+b+c, a+b+d, a+c+e, a+d+e, b+c+f, b+d+f, c+e+f, d+e+f));
                long cube = Collections.min(triple) * 4;
                long area = nums.get(0) * ((n-2) * (n-2) * 5 + ((n-2) * 4));
                long two = count - ((n-2) * (n-2) * 5 + ((n-2) * 4)) - 4;

                int af = Math.min(a, f);
                int be = Math.min(b, e);
                int cd = Math.min(c, d);
                int max = Math.max(Math.max(af, be), cd);
                int min = af + be + cd - max;

                two *= (long)min;

                ans = cube + area + two;
            } else {
                ans = a+b+c+d+e+f - nums.get(5);
            }
            out.print(ans);
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