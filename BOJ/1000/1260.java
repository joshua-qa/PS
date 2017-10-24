import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private ArrayList<Integer>[] graph;
    private int vertex, m, v;
    private boolean[] check;
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        vertex = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        int x, y;

        graph = (ArrayList<Integer>[]) new ArrayList[vertex+1];
        for(int i = 0; i <= vertex; i++) {
            graph[i] = new ArrayList<>();
        }
        check = new boolean[vertex+1];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }
        for(int i = 1; i < graph.length; i++) {
            graph[i].sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1-o2;
                }
            });
        }

        dfs(v);

        System.out.println("");

        Arrays.fill(check, false);
        bfs(v);
    }

    private void bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        check[n] = true;

        while(!queue.isEmpty()) {
            int x = queue.remove();
            System.out.print(x + " ");

            for (int i = 0; i < graph[x].size(); i++) {
                int t = graph[x].get(i);
                if (!check[t]) {
                    queue.add(t);
                    check[t] = true;
                }
            }
        }
    }

    private void dfs(int n) {
        if(check[n]) {
            return;
        }
        check[n] = true;
        System.out.print(n + " ");
        for (int i = 0; i < graph[n].size(); i++) {
            int t = graph[n].get(i);
            if(!check[t]) {
                dfs(t);
            }
        }
    }
}