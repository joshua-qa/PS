import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private int[] Dx = {-1, 0, 0, 1};
    private int[] Dy = {0, -1, 1, 0};
    private int[][] map;
    private int n, m;
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for(int i = 0; i < n; i++) {
            char[] ca = br.readLine().toCharArray();
            for(int j = 0; j < m; j++) {
                map[i][j] = ca[j] - '0';
            }
        }

        bfs(0, 0);
        System.out.println(map[n-1][m-1]);
    }

    private void bfs(int x, int y) {
        boolean[][] check = new boolean[n][m];
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(x,y));
        check[x][y] = true;

        while(!check[n-1][m-1]) {
            Position q = queue.remove();
            for(int i = 0; i < 4; i++) {
                if(q.x + Dx[i] < 0 || q.x + Dx[i] >= n || q.y + Dy[i] < 0 || q.y + Dy[i] >= m) {
                    continue;
                }
                if(map[q.x + Dx[i]][q.y + Dy[i]] != 0 && !check[q.x + Dx[i]][q.y + Dy[i]]) {
                    queue.add(new Position(q.x + Dx[i], q.y + Dy[i]));
                    check[q.x + Dx[i]][q.y + Dy[i]] = true;
                    map[q.x + Dx[i]][q.y + Dy[i]] = map[q.x][q.y] + 1;
                }
            }
        }
    }
}

class Position {
    int x;
    int y;
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}