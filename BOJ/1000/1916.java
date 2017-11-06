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

    static class Node {
        int value;
        Node leftChild;
        Node rightChild;

        public Node getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        public Node getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }

        public Node(int value) {
            this.value = value;
        }
    }

    static class Vertex implements Comparable<Vertex> {
        int index;
        int dist;

        public Vertex(int index, int dist) {
            this.index = index;
            this.dist = dist;
        }

        @Override
        public int compareTo(Vertex that) {
            if(this.dist > that.dist) {
                return 1;
            } else if(this.dist < that.dist) {
                return -1;
            }
            return 0;
        }
    }

    static class Task {
        final int INF = 987654321;
        int n, m, u, v, d;
        int[] dist;
        ArrayList<ArrayList<Vertex>> graph = new ArrayList<>();
        PriorityQueue<Vertex> queue = new PriorityQueue<>();
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            m = in.nextInt();
            dist = new int[n+1];

            for(int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
                dist[i] = INF;
            }

            for(int i = 0; i < m; i++) {
                u = in.nextInt();
                v = in.nextInt();
                d = in.nextInt();

                graph.get(u).add(new Vertex(v, d));
            }

            int start = in.nextInt();
            int end = in.nextInt();

            dist[start] = 0;

            queue.offer(new Vertex(start, 0));

            while(!queue.isEmpty()) {
                Vertex curr = queue.poll();

                if(curr.dist > dist[curr.index]) {
                    continue;
                }

                for(Vertex v : graph.get(curr.index)) {
                    if(dist[v.index] > curr.dist + v.dist) {
                        dist[v.index] = curr.dist + v.dist;
                        queue.offer(new Vertex(v.index, dist[v.index]));
                    }
                }
            }

            out.print(dist[end]);
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
            String s;
            try {
                s = reader.readLine();
            } catch (Exception e) {
                return "-1";
            }
            if(s == null || s.equals("")) {
                return "-1";
            }

            return s;
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