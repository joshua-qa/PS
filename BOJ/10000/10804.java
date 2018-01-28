import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

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
        public void run(InputReader in, PrintWriter out) {
            int[] array = IntStream.range(1, 21).toArray();

            for(int i = 0; i < 10; i++) {
                int s = in.nextInt()-1;
                int e = in.nextInt()-1;

                int[] temp = Arrays.copyOfRange(array, s, e+1);

                for(int j = s, k = temp.length-1; j <= e; j++, k--) {
                    array[j] = temp[k];
                }
            }

            StringBuilder sb = new StringBuilder();
            for(int i : array) {
                sb.append(i + " ");
            }

            out.print(sb);
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