import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    int n;
    int ans = Integer.MAX_VALUE;
    int[][] tsp;
    StringTokenizer st;
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        tsp = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                tsp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[] check = new boolean[n];

        rec(check, 0, n-1, 0);

        System.out.print(ans);
    }

    private void rec(boolean[] visit, int curr, int remain, int cost) {
        if(remain == 0) {
            ans = Math.min(ans, cost + tsp[curr][0]);
            return;
        }

        for(int i = 1; i < n; i++) {
            if(!visit[i] && tsp[curr][i] != 0) {
                visit[i] = true;
                rec(visit, i, remain - 1, cost + tsp[curr][i]);
                visit[i] = false;
            }
        }
    }
}