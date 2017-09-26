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
        int[][] board;
        boolean[] diag1, diag2;

        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            board = new int[n][n];
            diag1 = new boolean[n*2-1];
            diag2 = new boolean[n*2-1];

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    board[i][j] = in.nextInt();
                }
            }


            solve(0, 0);

            out.println(ans);
        }

        private void solve(int diag, int curr) {
            if(diag == n*2) {
                if (curr > ans) {
                    ans = curr;
                }
                return;
            }

            boolean flag = false;
            for(int i = diag; i >= 0; i--) {
                int currX = diag-i;
                int currY = i;
                if(currX >= n || currY >= n) {
                    continue;
                }
                if(board[currX][currY] == 1 && isPromising(currX, currY)) {
                    flag = true;
                    check(currX, currY);
                    solve(diag+1, curr+1);
                    check(currX, currY);
                }
            }
            if(!flag) {
                solve(diag+1, curr);
            }
        }

        private boolean isPromising(int x, int y) {
            return !diag2[x-y+n-1];
        }

        private void check(int x, int y) {
            if(diag1[x+y]) {
                diag1[x + y] = false;
                diag2[x - y + n - 1] = false;
            } else {
                diag1[x + y] = true;
                diag2[x - y + n - 1] = true;
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
    }
}