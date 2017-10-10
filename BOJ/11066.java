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
        int n, m, curr;
        int[] P, pSum;
        int[][] D;
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            while(n-- > 0) {
                m = in.nextInt();

                P = new int[m+1];
                pSum = new int[m+1];
                D = new int[m+1][m+1];

                for(int i = 1; i <= m; i++) {
                    P[i] = in.nextInt();
                    pSum[i] = pSum[i-1] + P[i];
                }

                for(int l = 1; l < m; l++) {
                    for(int i = 1, j = i+l; i <= m-l; i++, j = i+l) {
                        for(int k = i; k < j; k++) {
                            curr = D[i][k] + D[k+1][j] + (pSum[j] - pSum[i-1]);
                            if(D[i][j] == 0 || D[i][j] > curr) {
                                D[i][j] = curr;
                            }
                        }
                    }
                }

                out.println(D[1][m]);
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