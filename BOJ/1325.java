import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private ArrayList<Integer>[] graph;
    private ArrayList<Integer> maxList = new ArrayList<>();
    private boolean[] check;
    private int a, b, maxCount, n, count;
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        StringBuffer sb = new StringBuffer();
        int t;

        check = new boolean[n+1];
        graph = (ArrayList<Integer>[]) new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            graph[b].add(a);
        }

        for(int i = 1; i <= n; i++) {
            count = 0;
            Arrays.fill(check, false);
            t = dfs(i);
            if(t > maxCount) {
                maxCount = t;
                maxList.clear();
                maxList.add(i);
            } else if(t == maxCount) {
                maxList.add(i);
            }
        }

        for(int i : maxList) {
            sb.append(i + " ");
        }

        System.out.print(sb.toString());
    }

    private int dfs(int n) {
        if(check[n]) {
            return 0;
        }

        check[n] = true;
        count++;

        for(int i = 0; i < graph[n].size(); i++) {
            int t = graph[n].get(i);
            if(!check[t]) {
                dfs(t);
            }
        }

        return count;
    }
}