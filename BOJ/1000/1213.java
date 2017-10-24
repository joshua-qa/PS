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
        int[] alphabet = new int[26];
        int oddCount;
        public void run(InputReader in, PrintWriter out) {
            char[] A = in.next().toCharArray();

            for(char c : A) {
                alphabet[c - 'A']++;
            }

            for(int i : alphabet) {
                if(i % 2 == 1) {
                    oddCount++;
                }
            }

            if(oddCount == 1) {
                int len = A.length-1;
                for(int i = 0, j = 0; i < alphabet.length; i++) {
                    char c = (char)(i + 'A');
                    while(alphabet[i] > 1) {
                        A[len-j] = c;
                        A[j++] = c;
                        alphabet[i] -= 2;
                    }
                    if(alphabet[i] == 1) {
                        A[len/2] = c;
                    }
                }

                out.print(A);
            } else {
                out.print("I'm Sorry Hansoo");
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

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}