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
        ArrayList<Character> aeiou = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        public void run(InputReader in, PrintWriter out) {
            aeiou.add('a');
            aeiou.add('e');
            aeiou.add('i');
            aeiou.add('o');
            aeiou.add('u');
            while(true) {
                char[] input = in.nextLine().toLowerCase().toCharArray();
                if(input[0] == '#') {
                    break;
                }
                sb.append(check(input)).append("\n");
            }

            out.print(sb);
        }

        private int check(char[] text) {
            int result = 0;
            for(char c : text) {
                if(aeiou.contains(c)) {
                    result++;
                }
            }
            return result;
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

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}