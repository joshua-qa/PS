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
        int ans;
        public void run(InputReader in, PrintWriter out) {
            char[] text = in.next().toCharArray();

            for(int l = 0; l < text.length; l++) {
                char[] newText = Arrays.copyOfRange(text, l, text.length);
                int[] pi = getPi(newText);

                for (int i = 0; i < pi.length; i++) {
                    if (pi[i] > ans) {
                        ans = pi[i];
                    }
                }
            }

            out.print(ans);
        }

        private int[] getPi(char[] input) {
            int[] pi = new int[input.length];

            int len = input.length;
            int j = 0;
            for(int i = 1; i < len; i++) {
                while(j > 0 && input[i] != input[j]) {
                    j = pi[j-1];
                }
                if(input[i] == input[j]) {
                    pi[i] = ++j;
                }
            }

            return pi;
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