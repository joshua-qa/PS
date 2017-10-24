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
        int[] score1 = new int[10];
        int[] score2 = new int[10];
        public void run(InputReader in, PrintWriter out) {
            for(int i = 0; i < 10; i++) {
                score1[i] = in.nextInt();
            }
            for(int i = 0; i < 10; i++) {
                score2[i] = in.nextInt();
            }
            Arrays.sort(score1);
            Arrays.sort(score2);

            for(int i = 9; i > 6; i--) {
                n += score1[i];
                m += score2[i];
            }

            System.out.println(n + " " + m);
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