import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private ArrayList<Bridge>[] graph;
    private Queue<Integer> visit = new LinkedList<>();
    private boolean[] check;
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int min = 0;
        int max = 0;
        int mid = 0;
        int ans = 0;
        check = new boolean[n+1];
        graph = (ArrayList<Bridge> []) new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Bridge(b, c));
            graph[b].add(new Bridge(a, c));
            if(c > max) {
                max = c;
            }
        }

        str = br.readLine().split(" ");
        int x = Integer.parseInt(str[0]);
        int y = Integer.parseInt(str[1]);

        while(min <= max) {
            mid = (min + max) / 2;
            if(bfs(x, y, mid)) {
                ans = Math.max(ans, mid);
                min = mid+1;
            } else {
                max = mid-1;
            }
        }

        System.out.print(ans);
    }

    private boolean bfs(int x, int y, int mid) {
        Arrays.fill(check, false);
        boolean flag = false;
        visit.add(x);
        check[x] = true;

        while(!visit.isEmpty()) {
            int curr = visit.remove();

            if(curr == y) {
                while(!visit.isEmpty()) {
                    visit.remove();
                }
                return true;
            }
            for(int i = 0; i < graph[curr].size(); i++) {
                Bridge b = graph[curr].get(i);
                if(b.cost < mid || check[b.target]) {
                    continue;
                } else {
                    visit.add(b.target);
                    check[b.target] = true;
                }
            }
        }

        return flag;
    }
}

class Bridge {
    int target;
    int cost;
    public Bridge(int target, int cost) {
        this.target = target;
        this.cost = cost;
    }
}