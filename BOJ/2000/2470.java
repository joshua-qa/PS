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
        int n, ans = 2100000000;
        int[] elements;
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            elements = new int[n];

            for(int i = 0; i < n; i++) {
                elements[i] = in.nextInt();
            }

            Arrays.sort(elements);

            int left = 0;
            int right = n-1;

            int leftElement = 0;
            int rightElement = 0;

            while(left != right) {
                int curr = abs(elements[right] + elements[left]);
                if(abs(0 - ans) > curr) {
                    ans = curr;
                    leftElement = elements[left];
                    rightElement = elements[right];
                }

                if(abs(elements[left]) >= abs(elements[right])) {
                    left++;
                } else {
                    right--;
                }
            }

            out.print(leftElement + " " + rightElement);
        }
        
        public int abs(int x) {
            return x >= 0 ? x : -x;
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