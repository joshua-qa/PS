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
        StringBuilder sb = new StringBuilder();
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            while(n-- > 0) {
                sb.append(isAnagram(in.next().toCharArray(), in.next().toCharArray()) + "\n");
            }
            out.print(sb);
        }

        private String isAnagram(char[] firstWord, char[] secondWord) {
            String ans = String.valueOf(firstWord) + " & " + String.valueOf(secondWord) + " are ";
            int[] firstArray = new int[26];
            int[] secondArray = new int[26];

            for(char c: firstWord) {
                firstArray[c - 'a']++;
            }

            for(char c: secondWord) {
                secondArray[c - 'a']++;
            }

            for(int i = 0; i < firstArray.length; i++) {
                if(firstArray[i] != secondArray[i]) {
                    return ans + "NOT anagrams.";
                }
            }

            return ans + "anagrams.";
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