import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private Queue<Vertex> visit = new LinkedList<>();
    private int h, w, currX, currY;
    private boolean flag;
    private char[][] map;
    private boolean[][] check;
    private int[] Dx = {-1, 0, 0, 1};
    private int[] Dy = {0, -1, 1, 0};
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        map = new char[h][w];
        check = new boolean[h][w];

        for(int i = 0; i < h; i++) {
            map[i] = br.readLine().toCharArray();
        }
        // 0 : 48, 1 : 49

        for(int i = 0; i < w; i++) {
            if(map[0][i] == 49 || check[0][i]) {
                continue;
            } else {
                bfs(0, i);
            }
        }

        for(int i = 0; i < w; i++) {
            if(check[h-1][i]) {
                flag = true;
            }
        }

        System.out.print(flag ? "YES" : "NO");
    }

    private void bfs(int x, int y) {
        visit.add(new Vertex(x, y));
        check[x][y] = true;

        while(!visit.isEmpty()) {
            Vertex t = visit.remove();

            for(int i = 0; i < Dx.length; i++) {
                currX = t.x + Dx[i];
                currY = t.y + Dy[i];

                if(currX < 0 || currY < 0 || currX >= map.length || currY >= map[0].length) {
                    continue;
                }
                if(!check[currX][currY] && map[currX][currY] != 49) {
                    visit.add(new Vertex(currX, currY));
                    check[currX][currY] = true;
                }
            }
        }
    }
}

class Vertex {
    int x;
    int y;
    public Vertex(int x, int y) {
        this.x = x;
        this.y = y;
    }
}