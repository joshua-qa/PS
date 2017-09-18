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
        StringBuilder sb = new StringBuilder();
        public void run(InputReader in, PrintWriter out) {

            n = in.nextInt();

            for(int i = 0; i < n; i++) {
                int docCount = in.nextInt();
                int queryIndex = in.nextInt();
                Queue<Integer> printer = new PriorityQueue<>(docCount, Collections.reverseOrder());
                ArrayList<Integer> docs = new ArrayList<>();
                Deque<Document> deque = new ArrayDeque<>();
                for(int j = 0; j < docCount; j++) {
                    int curr = in.nextInt();
                    docs.add(curr);
                    deque.addLast(new Document(j+1, curr));
                }

                printer.addAll(docs);

                int j = 0;
                while(!deque.isEmpty()) {
                    Document d = deque.pollFirst();
                    if(d.priority == printer.peek()) {
                        printer.poll();
                        ++j;
                        if(d.num == queryIndex+1) {
                            sb.append(j + "\n");
                        }
                    } else {
                        deque.addLast(d);
                    }
                }
            }

            System.out.print(sb);
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

class Document {
    int num;
    int priority;

    public Document(int n, int p) {
        super();
        this.num = n;
        this.priority = p;
    }
}