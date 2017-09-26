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
        boolean flag;
        String ans = "";

        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();

            solve("1", 1);
            out.println(ans);
        }

        private void solve(String num, int numSize) {
            if(numSize == n) {
                if(ans.length() == 0) {
                    ans = num;
                    flag = true;
                }
                return;
            }

            if(flag) {
                return;
            }
            for(int i = 1; i <= 3; i++) {
                if(num.charAt(num.length()-1) - '0' == i) {
                    continue;
                }
                if(isPromising(num + i)) {
                    solve(num + i, numSize + 1);
                }
            }
        }

        private boolean isPromising(String nums) {
            char[] ca = nums.toCharArray();
            boolean duplicated;

            for(int i = ca.length-1; i >= (ca.length+1)/2; i--) {
                duplicated = true;
                int size = (ca.length - i) * 2;
                for(int j = ca.length-size, k = 0; j <= i-1; j++, k++) {
                    if(ca[j] != ca[i + k]) {
                        duplicated = false;
                        break;
                    }
                }

                if(duplicated) {
                    return false;
                }
            }

            return true;
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