import java.io.*;
import java.math.BigInteger;
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
        int n, m, ans;
        boolean zeroFlag;
        ArrayList<Integer> numList = new ArrayList<>();
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();

            for (int i = 0; i < n; i++) {
                m = in.nextInt();
                if(m != 0) {
                    numList.add(m);
                } else {
                    zeroFlag = true;
                }
            }

            if(numList.size() > 1) {
                numList.sort(Comparator.reverseOrder());

                int size = numList.size();
                int two = Math.max(numList.get(0) * numList.get(1), numList.get(size - 2) * numList.get(size - 1));
                ans = two;
                if(numList.size() > 2) {
                    int three1 = numList.get(0) * numList.get(1) * numList.get(2);
                    int three2 = numList.get(0) * numList.get(size - 1) * numList.get(size - 2);
                    ans = Math.max(ans, Math.max(three1, three2));
                }
            }

            if(zeroFlag && ans < 0) {
                ans = 0;
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