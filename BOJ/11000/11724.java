import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    ArrayList<Integer>[] graph;
    int n, m, x, y, ans;
    boolean[] check;
    StringTokenizer st;
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = (ArrayList<Integer>[]) new ArrayList[n+1];
        check = new boolean[n+1];

        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }

        for(int i = 1; i <= n; i++) {
            if(!check[i]) {
                dfs(i);
                ans++;
            }
        }
        System.out.print(ans);
    }

    private void dfs(int n) {
        if(check[n]) {
            return;
        } else {
            check[n] = true;
            for(int i = 0; i < graph[n].size(); i++) {
                dfs(graph[n].get(i));
            }
        }
    }
}