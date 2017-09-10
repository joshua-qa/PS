import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    int[] ind, cost, D;
    int n, v, ans;
    Deque<Integer> visit = new ArrayDeque<>();
    ArrayList<Integer>[] graph;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    private void run() throws IOException {
        n = Integer.parseInt(br.readLine());
        graph = (ArrayList<Integer> []) new ArrayList[n+1];
        ind = new int[n+1];
        cost = new int[n+1];
        D = new int[n+1];

        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            cost[i] = Integer.parseInt(st.nextToken());
            ind[i] = Integer.parseInt(st.nextToken());
            for(int j = 0; j < ind[i] && st.hasMoreTokens(); j++) {
                v = Integer.parseInt(st.nextToken());
                graph[v].add(i);
            }
        }

        for(int i = 1; i <= n; i++) {
            if(ind[i] == 0) {
                visit.addLast(i);
            }
            D[i] = cost[i];
        }

        while(!visit.isEmpty()) {
            int curr = visit.removeFirst();

            for(int i : graph[curr]) {
                ind[i]--;

                if(D[curr] + cost[i] > D[i]) {
                    D[i] = D[curr] + cost[i];
                }

                if(ind[i] == 0) {
                    visit.addLast(i);
                }
            }
        }

        for(int i : D) {
            if(i > ans) {
                ans = i;
            }
        }

        System.out.println(ans);
    }
}