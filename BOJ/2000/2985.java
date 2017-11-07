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
        int n, m, k;
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            m = in.nextInt();
            k = in.nextInt();

            if(n + m == k) {
                out.print(n + "+" + m + "=" + k);
            } else if(n - m == k) {
                out.print(n + "-" + m + "=" + k);
            } else if(n * m == k) {
                out.print(n + "*" + m + "=" + k);
            } else if(n / m == k) {
                out.print(n + "/" + m + "=" + k);
            } else {
                if(m + k == n) {
                    out.print(n + "=" + m + "+" + k);
                } else if(m - k == n) {
                    out.print(n + "=" + m + "-" + k);
                } else if(m * k == n) {
                    out.print(n + "=" + m + "*" + k);
                } else if(m / k == n) {
                    out.print(n + "=" + m + "/" + k);
                }
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