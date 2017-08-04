import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    int[][] map, dp;
    int n, m;
    StringTokenizer st;
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);

        map = new int[n][m];
        dp = new int[n][m];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.print(rec(0, 0));
    }

    private int rec(int x, int y) {
        if(x == n-1 && y == m-1) {
            return 1;
        }
        if(dp[x][y] != -1) {
            return dp[x][y];
        }

        dp[x][y] = 0;

        if(x-1 >= 0 && map[x][y] > map[x-1][y]) {
            dp[x][y] += rec(x-1, y);
        }

        if(x+1 < n && map[x][y] > map[x+1][y]) {
            dp[x][y] += rec(x+1, y);
        }

        if(y-1 >= 0 && map[x][y] > map[x][y-1]) {
            dp[x][y] += rec(x, y-1);
        }

        if(y+1 < m && map[x][y] > map[x][y+1]) {
            dp[x][y] += rec(x, y+1);
        }

        return dp[x][y];
    }
}