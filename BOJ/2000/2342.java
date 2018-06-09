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
        int n, ans = 999999999;
        int[] move;
        int[][][] D;
        public void run(InputReader in, PrintWriter out) {
            StringTokenizer st = new StringTokenizer(in.nextLine(), " ");
            n = st.countTokens() - 1;
            move = new int[n];
            D = new int[5][5][n];

            for(int i = 0; i < n; i++) {
                move[i] = Integer.parseInt(st.nextToken());
            }

            D[0][move[0]][0] = 2;
            D[move[0]][0][0] = 2;

            for(int i = 1; i < n; i++) {
                for(int j = 0; j < 5; j++) {
                    for(int k = 0; k < 5; k++) {
                        if(D[j][k][i-1] == 0) {
                            continue;
                        }
                        if(D[j][move[i]][i] == 0) {
                            D[j][move[i]][i] = D[j][k][i-1] + cal(k, move[i]);
                        } else {
                            D[j][move[i]][i] = Math.min(D[j][k][i - 1] + cal(k, move[i]), D[j][move[i]][i]);
                        }
                        if(D[move[i]][j][i] == 0) {
                            D[move[i]][j][i] = D[k][j][i-1] + cal(k, move[i]);
                        } else {
                            D[move[i]][j][i] = Math.min(D[k][j][i-1] + cal(k, move[i]), D[move[i]][j][i]);
                        }
                    }
                }
            }

            for(int i = 0; i < 5; i++) {
                for(int j = 0; j < 5; j++) {
                    if(D[i][j][n-1] == 0) {
                        continue;
                    }
                    ans = Math.min(ans, D[i][j][n-1]);
                }
            }

            out.print(ans);
        }
        private int cal(int s, int d) {
            if(s == 0) {
                return 2;
            }
            return (d - s == 2 || d - s == -2) ? 4 : d == s ? 1 : 3;
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