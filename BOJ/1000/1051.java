import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    int n, m, ans = 1;
    char[][] map;
    StringTokenizer st;
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];

        for(int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                for(int k = j+1; k < m; k++) {
                    if(map[i][j] == map[i][k]) {
                        ans = Math.max(check(i, j, k), ans);
                    }
                }
            }
        }

        System.out.print(ans);
    }

    private int check(int x, int yStart, int yEnd) {
        int w = yEnd-yStart;
        int num = map[x][yStart];
        if(x + w >= n) {
            return -1;
        } else if(map[x + w][yStart] != num || map[x + w][yEnd] != num) {
            return -1;
        }

        return (w+1) * (w+1);
    }
}