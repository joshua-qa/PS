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
        int max, maxIndex, length, result;
        int[] palindrome;
        public void run(InputReader in, PrintWriter out) {
            String input = in.nextLine();
            length = input.length();
            char[] string = init(input);
            solve(string);
            max = palindrome[maxIndex];
            if ((max & 1) == 1) {
                result = (string[maxIndex] == '#') ? max + 1 : max;
            } else {
                result = (string[maxIndex] == '#') ? max : max + 1;
            }
            out.print(result);
        }

        private char[] init(String input) {
            char[] temp = new char[length * 2 + 1];
            for (int i = 0, j = 0; i < length; i++) {
                temp[j++] = '#';
                temp[j++] = input.charAt(i);
            }
            temp[temp.length-1] = '#';
            return temp;
        }

        private void solve(char[] string) {
            length = string.length;
            palindrome = new int[length];
            int r = 0, p = 0;

            for (int i = 0; i < length; i++) {
                if (i <= r) {
                    palindrome[i] = min(palindrome[2 * p - i], r - i);
                }
                while (i - palindrome[i] - 1 >= 0 && i + palindrome[i] + 1 < length && string[i - palindrome[i] - 1] == string[i + palindrome[i] + 1]) {
                    palindrome[i]++;
                }
                if (i + palindrome[i] > r) {
                    r = i + palindrome[i];
                    p = i;
                }

                if (palindrome[i] > palindrome[maxIndex]) {
                    maxIndex = i;
                }
            }
        }

        private int min(int x, int y) {
            return (x <= y) ? x : y;
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
