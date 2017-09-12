import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    int n, m, line, ans;
    int[] union;
    StringTokenizer st;
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        union = new int[n+1];

        for(int i = 1; i <= n; i++) {
            union[i] = i;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>(m);
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            pq.offer(new Edge(u, v, cost));
        }

        while(!pq.isEmpty() && line < n-1) {
            Edge e = pq.poll();
            if(find(e.u) == find(e.v)) {
                continue;
            } else {
                union(e.u, e.v);
                line++;
                ans += e.cost;
            }
        }

        System.out.print(ans);
    }

    private void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x == y) {
            return;
        }
        union[y] = x;
    }

    private int find(int n) {
        if(union[n] == n) {
            return n;
        } else {
            return union[n] = find(union[n]);
        }
    }
}

class Edge implements Comparable<Edge> {
    int u;
    int v;
    int cost;
    public Edge(int u, int v, int cost) {
        this.u = u;
        this.v = v;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}