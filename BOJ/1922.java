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

        n = Integer.parseInt(br.readLine());
        union = new int[n+1];

        m = Integer.parseInt(br.readLine());
        Edge[] graph = new Edge[m];

        for(int i = 1; i <= n; i++) {
            union[i] = i;
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[i] = new Edge(u, v, cost);
        }

        Arrays.sort(graph, Comparator.comparingInt(p -> p.cost));

        for(Edge e : graph) {
            int x = find(e.u);
            int y = find(e.v);
            if(x == y) {
                continue;
            } else if(x != y) {
                union(x, y);
                line++;
                ans += e.cost;
            }
            if(line == n-1) {
                break;
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

class Edge {
    int u;
    int v;
    int cost;
    public Edge(int u, int v, int cost) {
        this.u = u;
        this.v = v;
        this.cost = cost;
    }
}