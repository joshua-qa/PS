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
        int n, firstNode, secondNode, start, end, dist, maxNodeDist, result;
        boolean isEnded;
        boolean[] visit;
        Stack<Integer> dists = new Stack<>();
        List<List<Node>> graph = new ArrayList<>();
        public void run(InputReader in, PrintWriter out) {
            n = in.nextInt();
            visit = new boolean[n+1];
            firstNode = in.nextInt();
            secondNode = in.nextInt();

            for(int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            for(int i = 0; i < n-1; i++) {
                start = in.nextInt();
                end = in.nextInt();
                dist = in.nextInt();
                graph.get(start).add(new Node(end, dist));
                graph.get(end).add(new Node(start, dist));
            }

            dfs(firstNode, 0);

            out.print(result - maxNodeDist);
        }

        private void dfs(int currPoint, int currDist) {
            if(currPoint == secondNode) {
                result = currDist;
                while(!dists.isEmpty()) {
                    int curr = dists.pop();
                    if(maxNodeDist < curr) {
                        maxNodeDist = curr;
                    }
                }
                isEnded = true;
                return;
            }

            if(isEnded) {
                return;
            }
            visit[currPoint] = true;
            for(Node node : graph.get(currPoint)) {
                if(isEnded || visit[node.getIndex()]) {
                    continue;
                }
                dists.push(node.getDist());
                dfs(node.getIndex(), currDist + node.getDist());
                if(!dists.isEmpty()) {
                    dists.pop();
                }
            }
        }
    }

    static class Node {
        int index;
        int dist;

        public Node(int index, int dist) {
            this.index = index;
            this.dist = dist;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getDist() {
            return dist;
        }

        public void setDist(int dist) {
            this.dist = dist;
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