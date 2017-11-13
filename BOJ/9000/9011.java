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
        int n, count;
        StringBuilder sb = new StringBuilder();
        Stack<Integer> currList = new Stack<>();
        ArrayList<Integer> numList = new ArrayList<>();
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();

            while(n-- > 0) {
                count = in.nextInt();
                int[] rank = new int[count];
                for(int i = 1; i <= count; i++) {
                    rank[i-1] = in.nextInt();
                    numList.add(i);
                }

                for(int i = count-1; i >= 0; i--) {
                    if(numList.size() > rank[i]) {
                        currList.push(numList.remove(rank[i]));
                    } else {
                        break;
                    }
                }

                if(!numList.isEmpty()) {
                    numList.clear();
                    currList.clear();
                    sb.append("IMPOSSIBLE\n");
                } else {
                    while(!currList.isEmpty()) {
                        sb.append(currList.pop() + " ");
                    }
                    sb.append("\n");
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

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
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