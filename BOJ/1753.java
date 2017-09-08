import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    int n, m, u, v, d, start;
    int[] shortest;
    final int INF = 987654321;
    boolean[] check;
    ArrayList<ArrayList<Vertex>> graph;
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    private void run() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>(n + 1);
        shortest = new int[n+1];
        check = new boolean[n+1];
        Arrays.fill(shortest, 1, n+1, INF);

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        start = Integer.parseInt(br.readLine());
        shortest[start] = 0;

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Vertex(v, d));
        }

        dijkstra(start);

        for(int i = 1; i <= n; i++) {
            if(shortest[i] != INF) {
                sb.append(shortest[i] + "\n");
            } else {
                sb.append("INF\n");
            }
        }
        System.out.print(sb);
    }

    private void dijkstra(int n) {
        Queue<Vertex> visit = new PriorityQueue<>();

        visit.offer(new Vertex(n, 0));

        while(!visit.isEmpty()) {
            Vertex curr = visit.poll();

            if(curr.dist > shortest[curr.x]) {
                continue;
            }

            for(Vertex v : graph.get(curr.x)) {
                if(shortest[v.x] > curr.dist + v.dist) {
                    shortest[v.x] = curr.dist + v.dist;
                    visit.offer(new Vertex(v.x, shortest[v.x]));
                }
            }
        }
    }
}

class Vertex implements Comparable<Vertex> {
    int x;
    int dist;
    public Vertex(int x, int dist) {
        this.x = x;
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