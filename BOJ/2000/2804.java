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
        public void run(InputReader in, PrintWriter out) {
            char[] A = in.next().toCharArray();
            char[] B = in.next().toCharArray();
            int firstMatchA = -1;
            int firstMatchB = -1;

            for(int i = 0; i < A.length && firstMatchA < 0; i++) {
                for(int j = 0; j < B.length; j++) {
                    if(A[i] == B[j]) {
                        firstMatchA = i;
                        firstMatchB = j;
                        break;
                    }
                }
            }

            for(int i = 0; i < B.length; i++) {
                for(int j = 0; j < A.length; j++) {
                    if(i != firstMatchB && j == firstMatchA) {
                        out.print(B[i]);
                    } else if(i == firstMatchB) {
                        out.print(A[j]);
                    } else {
                        out.print(".");
                    }
                }
                out.println();
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