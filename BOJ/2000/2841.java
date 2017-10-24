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
        int n, m, line, fret, ans;
        Stack<Integer>[] guitar = new Stack[6];
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            m = in.nextInt();
            for(int i = 0; i < guitar.length; i++) {
                guitar[i] = new Stack<>();
            }

            for(int i = 0; i < n; i++) {
                line = in.nextInt() - 1;
                fret = in.nextInt();
                if(guitar[line].isEmpty()) {
                    guitar[line].push(fret);
                    ans++;
                } else if(guitar[line].peek() == fret){
                    continue;
                } else if(guitar[line].peek() < fret) {
                    guitar[line].push(fret);
                    ans++;
                } else if(guitar[line].peek() > fret) {
                    while(!guitar[line].isEmpty() && guitar[line].peek() > fret) {
                        guitar[line].pop();
                        ans++;
                    }
                    if(guitar[line].isEmpty() || guitar[line].peek() < fret) {
                        guitar[line].push(fret);
                        ans++;
                    } else {
                        continue;
                    }
                }
            }

            System.out.println(ans);
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