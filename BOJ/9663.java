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
        int n, ans;
        boolean[] width;
        boolean[] dig1;
        boolean[] dig2;
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();

            width = new boolean[n];
            dig1 = new boolean[n*2-1];
            dig2 = new boolean[n*2-1];

            for(int i = 0; i < n; i++) {
                changeOn(0, i);
                dfs(0);
                changeOff(0, i);
            }

            out.println(ans);
        }

        private void dfs(int x) {
            if(x == n-1) {
                ans++;
                return;
            }

            for(int i = 0; i < n; i++) {
                if(width[i] || !check(x+1, i)) {
                    continue;
                } else {
                    changeOn(x+1, i);
                    dfs(x+1);
                    changeOff(x+1, i);
                }
            }
        }

        private boolean check(int x, int y) {
            return !dig1[x+y] && !dig2[x-y+n-1];
        }

        private void changeOn(int x, int y) {
            width[y] = true;
            dig1[x+y] = true;
            dig2[x-y+n-1] = true;
        }

        private void changeOff(int x, int y) {
            width[y] = false;
            dig1[x+y] = false;
            dig2[x-y+n-1] = false;
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