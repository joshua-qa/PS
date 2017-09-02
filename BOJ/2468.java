import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    int n, ans, curr, currX, currY;
    final int WALL = 101;
    int[][] map;
    boolean[] list = new boolean[101];
    boolean[][] check;
    int[] Dx = {-1, 0, 0, 1};
    int[] Dy = {0, -1, 1, 0};
    StringTokenizer st;
    Queue<Area> visit = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        check = new boolean[n][n];
        list[0] = true;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(!list[map[i][j]]) {
                    list[map[i][j]] = true;
                }
            }
        }

        for(int i = 0; i <= 100; i++) {
            if(!list[i]) {
                continue;
            }
            curr = solve(i);
            if(curr >= ans) {
                ans = curr;
            }
            for(int j = 0; j < n; j++) {
                Arrays.fill(check[j], false);
            }
        }

        System.out.print(ans);
    }

    private int solve(int r) {
        int safeCount = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] == r) {
                    map[i][j] = WALL;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] != WALL && !check[i][j]) {
                    bfs(i, j);
                    safeCount++;
                }
            }
        }

        return safeCount;
    }

    private void bfs(int x, int y) {
        visit.add(new Area(x, y));
        check[x][y] = true;

        while(!visit.isEmpty()) {
            Area a = visit.remove();

            for(int i = 0; i < Dx.length; i++) {
                currX = a.x + Dx[i];
                currY = a.y + Dy[i];
                if(currX < 0 || currX >= n || currY < 0 || currY >= n) {
                    continue;
                }

                if(!check[currX][currY] && map[currX][currY] != WALL) {
                    visit.add(new Area(currX, currY));
                    check[currX][currY] = true;
                }
            }
        }
    }
}

class Area {
    int x;
    int y;
    public Area(int x, int y) {
        this.x = x;
        this.y = y;
    }
}