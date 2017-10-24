import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    ArrayList<Integer> areaList = new ArrayList<>();
    int n, m, k, x1, y1, x2, y2, currX, currY;
    boolean[][] check;
    int[][] map;
    int[] Dx = {-1, 0, 0, 1};
    int[] Dy = {0, -1, 1, 0};
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    Queue<Area> visit = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        check = new boolean[n][m];

        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            fill(x1, y1, x2, y2);
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 0 && !check[i][j]) {
                    areaList.add(bfs(i, j));
                }
            }
        }

        Collections.sort(areaList);
        sb.append(areaList.size() + "\n");
        for(int i : areaList) {
            sb.append(i + " ");
        }

        System.out.print(sb);
    }

    private void fill(int x1, int y1, int x2, int y2) {
        for(int i = x1; i < x2; i++) {
            for(int j = y1; j < y2; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 2;
                }
            }
        }
    }

    private int bfs(int x, int y) {
        int ans = 0;

        visit.add(new Area(x, y));
        check[x][y] = true;

        while(!visit.isEmpty()) {
            Area a = visit.remove();
            ans++;

            for(int i = 0; i < Dx.length; i++) {
                currX = a.x + Dx[i];
                currY = a.y + Dy[i];
                if(currX < 0 || currX >= n || currY < 0 || currY >= m) {
                    continue;
                }

                if(!check[currX][currY] && map[currX][currY] != 2) {
                    visit.add(new Area(currX, currY));
                    check[currX][currY] = true;
                }
            }
        }

        return ans;
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