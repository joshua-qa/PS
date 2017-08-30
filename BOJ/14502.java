import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    int[] Dx = {-1, 0, 0, 1};
    int[] Dy = {0, -1, 1, 0};
    int[][] map;
    boolean[][] check;
    int n, m, available, max, res, currX, currY;
    ArrayList<Point> virusList = new ArrayList<>();
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
        max = n * m;
        check = new boolean[n][m];
        available = max - 3;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] != 0) {
                    available--;
                    if(map[i][j] == 2) {
                        virusList.add(new Point(i, j));
                    }
                }
            }
        }

        for(int i = 0; i < max - 2; i++) {
            if(map[i / m][i % m] != 0) {
                continue;
            }
            map[i / m][i % m] = 1;
            for(int j = i+1; j < max - 1; j++) {
                if(map[j / m][j % m] != 0) {
                    continue;
                }
                map[j / m][j % m] = 1;
                for(int k = j+1; k < max; k++) {
                    if(map[k / m][k % m] != 0) {
                        continue;
                    }
                    map[k / m][k % m] = 1;
                    int curr = bfs();
                    if(curr > res) {
                        res = curr;
                    }
                    map[k / m][k % m] = 0;
                }
                map[j / m][j % m] = 0;
            }
            map[i / m][i % m] = 0;
        }

        System.out.print(res);
    }

    private int bfs() {
        for(int i = 0; i < n; i++) {
            Arrays.fill(check[i], false);
        }
        int ans = 0;
        Queue<Point> visit = new LinkedList<>();
        for(Point p : virusList) {
            visit.add(p);
            check[p.x][p.y] = true;
        }

        while(!visit.isEmpty()) {
            Point p = visit.remove();

            for(int i = 0; i < Dx.length; i++) {
                currX = p.x + Dx[i];
                currY = p.y + Dy[i];
                if(currX < 0 || currX >= n || currY < 0 || currY >= m) {
                    continue;
                }
                if(!check[currX][currY] && map[currX][currY] == 0) {
                    check[currX][currY] = true;
                    ans++;
                    visit.add(new Point(currX, currY));
                }
            }
        }
        return available - ans;
    }
}

class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}