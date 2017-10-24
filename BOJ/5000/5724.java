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
        int[] D = new int[101];
        StringBuilder sb = new StringBuilder();
        public void run(InputReader in, PrintWriter out) {
            getSquare();
            while(true) {
                n = in.nextInt();
                if(n == 0) {
                    break;
                } else {
                    sb.append(D[n]).append("\n");
                }
            }

            out.print(sb);
        }

        public void getSquare() {
            int width = 1;
            int plus = 1;
            for(int i = 1; i <= 100; i++, width++, plus = width*width) {
                D[i] = D[i-1] + plus;
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