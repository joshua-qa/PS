import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private int[][][] map = new int[1001][1001][2];
    private int[][] P = new int[1001][1001];
    private StringTokenizer st;
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int n = parseInt(str[0]);
        int m = parseInt(str[1]);

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= m; j++) {
                P[i][j] = parseInt(st.nextToken());
            }
        }

        int max = 0;
        int currmax = 0;
        map[1][1][0] = P[1][1];
        map[1][1][1] = P[1][1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                currmax = Math.max(map[i][j][0], map[i][j][1]);
                max = Math.max(currmax, max);
                if(i+1 <= n) {
                    map[i+1][j][1] = currmax + P[i+1][j];
                }
                if(j+1 <= m) {
                    map[i][j+1][0] = currmax + P[i][j+1];
                }
            }
        }

        System.out.println(max);
    }

    private int parseInt(String str) {
        return Integer.parseInt(str);
    }
}