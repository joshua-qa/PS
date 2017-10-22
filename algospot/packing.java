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
        int c, n, w;
        int[] P, weight;
        int[][] D, used;
        String[] list;
        Stack<String> storeList = new Stack<>();
        StringBuilder sb = new StringBuilder();
        public void run(InputReader in, PrintWriter out) {
            c = in.nextInt();

            while(c-- > 0) {
                n = in.nextInt();
                w = in.nextInt();
                list = new String[n+1];
                P = new int[n+1];
                weight = new int[n+1];
                D = new int[n+1][w+1];
                used = new int[w+1][n+1];
                int max = 0;
                int maxValueWeight = 0;

                for (int i = 1; i <= n; i++) {
                    list[i] = in.next();
                    weight[i] = in.nextInt();
                    P[i] = in.nextInt();
                }

                for(int j = 1; j <= n; j++) {
                    for(int i = 1; i <= w; i++) {
                        if(i - weight[j] < 0) {
                            D[j][i] = D[j-1][i];
                            continue;
                        } else {
                            if(D[j-1][i - weight[j]] + P[j] > D[j-1][i]) {
                                D[j][i] = D[j-1][i - weight[j]] + P[j];
                                used[i][j] = 1;

                                if(max < D[j][i]) {
                                    max = D[j][i];
                                    maxValueWeight = i;
                                }
                            } else {
                                D[j][i] = D[j-1][i];
                            }
                        }
                    }
                }
                int index = n;
                while(maxValueWeight >= 0 && index >= 0) {
                    if(used[maxValueWeight][index] == 0) {
                        index--;
                        continue;
                    } else {
                        storeList.push(list[index]);
                        maxValueWeight -= weight[index];
                        index--;
                    }
                }

                sb.append(max + " " + storeList.size()).append("\n");
                while(!storeList.empty()) {
                    sb.append(storeList.pop()).append("\n");
                }
            }

            out.print(sb);
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