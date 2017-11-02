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
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();

            int[] alphabet = new int[26];
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < n; i++) {
                char[] ca = in.next().toCharArray();

                alphabet[ca[0] - 'a']++;
            }

            for(int i = 0; i < alphabet.length; i++) {
                if(alphabet[i] >= 5) {
                    sb.append((char)(i + 'a'));
                }
            }

            if(sb.length() == 0) {
                out.print("PREDAJA");
            } else {
                out.print(sb);
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