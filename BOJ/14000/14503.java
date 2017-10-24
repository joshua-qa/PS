import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    final int NORTH = 0;
    final int EAST = 1;
    final int SOUTH = 2;
    final int WEST = 3;
    int n, m, r, c, d, ans, back, wside;
    int[][] map;
    int[] Dx = {-1, 0, 1, 0};
    int[] Dy = {0, 1, 0, -1};
    StringTokenizer st;
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true) {
            if(map[r][c] == 0) {
                map[r][c] = 2;
                ans++;
            }
            back = (d == NORTH) ? SOUTH : (d == EAST) ? WEST : (d == WEST) ? EAST : NORTH;
            wside = (d == NORTH) ? WEST : (d == WEST) ? SOUTH : (d == SOUTH) ? EAST : NORTH;
            boolean checkFlag = check(r, c);
            if(!checkFlag && map[r + Dx[back]][c + Dy[back]] == 1) {
                break;
            } else if(!checkFlag && map[r + Dx[back]][c + Dy[back]] != 1) {
                r += Dx[back];
                c += Dy[back];
                continue;
            }

            d = wside;
            if(map[r + Dx[d]][c + Dy[d]] == 0) {
                r += Dx[d];
                c += Dy[d];
                continue;
            } else {
                continue;
            }
        }

        System.out.print(ans);
    }

    private boolean check(int x, int y) {
        int availableCount = 0;
        for(int i = 0; i < Dx.length; i++) {
            int currX = x + Dx[i];
            int currY = y + Dy[i];
            if(currX < 0 || currX >= n || currY < 0 || currY >= m) {
                continue;
            }
            if(map[currX][currY] == 0) {
                availableCount++;
            }
        }
        return availableCount > 0;
    }
}