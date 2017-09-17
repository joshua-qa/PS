package Joshua.PS.BOJ;

import java.io.*;
import java.util.StringTokenizer;

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
        int ans, x, y;
        double z;
        StringBuilder sb = new StringBuilder();
        public void run(InputReader in, PrintWriter out) {
            String s;
            while((s = in.next()) != null) {
                x = Integer.parseInt(s);
                y = in.nextInt();
                z = (double)x / (double)y;
                sb.append(search(1, y*2, (int)z+1) + "\n");
            }

            out.println(ans);
        }

        public int search(int start, int end, int target) {
            int mid = 0;
            while(start < end) {
                mid = (start + end);

                int newX = x + mid;
                int newY = y + mid;
                double newZ = (double) newX / (double) newY;

                if (newZ < target) {
                    start = mid+1;
                } else {
                    end = mid-1;
                }
            }

            return mid;
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