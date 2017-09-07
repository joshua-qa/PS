import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    int n, m, currX, currY, ans;
    char[][] map;
    int[][] curr;
    int[] Dx = {-1, 0, 0, 1};
    int[] Dy = {0, -1, 1, 0};
    Queue<Pair> visit = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);

        map = new char[n][m];
        curr = new int[n][m];

        for(int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 'L' && isStartPoint(i, j)) {
                    bfs(i, j);
                }
            }
        }

        System.out.print(ans);
    }

    private boolean isStartPoint(int x, int y) {
        int count = 0;
        int wcount = 0;
        int hcount = 0;

        for(int i = 0; i < Dx.length; i++) {
            currX = x + Dx[i];
            currY = y + Dy[i];
            if(currX < 0 || currX >= n || currY < 0 || currY >= m) {
                continue;
            }
            if(map[currX][currY] == 'L') {
                count++;
                if(i == 0 || i == 3) {
                    wcount++;
                } else {
                    hcount++;
                }
            }
        }

        return count == 1 || (count == 2 && wcount == 1 && hcount == 1);
    }

    private void bfs(int x, int y) {
        curr[x][y] = 0;
        boolean[][] check = new boolean[n][m];
        visit.add(new Pair(x, y));
        check[x][y] = true;

        while(!visit.isEmpty()) {
            Pair p = visit.remove();

            for(int i = 0; i < Dx.length; i++) {
                currX = p.x + Dx[i];
                currY = p.y + Dy[i];
                if(currX < 0 || currX >= n || currY < 0 || currY >= m) {
                    continue;
                }
                if(!check[currX][currY] && map[currX][currY] != 'W') {
                    curr[currX][currY] = curr[p.x][p.y] + 1;
                    ans = Math.max(ans, curr[currX][currY]);
                    check[currX][currY] = true;
                    visit.add(new Pair(currX, currY));
                }
            }
        }
    }
}

class Pair {
    int x;
    int y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}