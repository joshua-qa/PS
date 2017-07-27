import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private int[] Dx = {-1, 0, 0, 1};
    private int[] Dy = {0, -1, 1, 0};
    private ArrayList<Tomato> tomatoList = new ArrayList<>();
    private int[][] map;
    private int n, m;
    private Queue<Tomato> visit = new LinkedList<>();
    private StringTokenizer st;
    private boolean[][] check;
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        m = Integer.parseInt(str[0]);
        n = Integer.parseInt(str[1]);
        int result = 0;
        boolean flag = true;

        map = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) {
                    tomatoList.add(new Tomato(i, j));
                }
            }
        }

        for(Tomato t : tomatoList) {
            bfs(t.x, t.y);
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 0) {
                    flag = false;
                    break;
                } else {
                    result = Math.max(result, map[i][j]);
                }
            }
            if(!flag) {
                break;
            }
        }

        if(flag) {
            if(result == 0) {
                System.out.println("0");
            } else {
                System.out.println(result - 1);
            }
        } else {
            System.out.println("-1");
        }
    }

    private void bfs(int x, int y) {
        int currX = 0, currY = 0;
        check = new boolean[n][m];
        visit.add(new Tomato(x, y));
        check[x][y] = true;

        while(!visit.isEmpty()) {
            Tomato t = visit.remove();

            for(int i = 0; i < 4; i++) {
                currX = t.x + Dx[i];
                currY = t.y + Dy[i];
                if(currX >= 0 && currY >= 0 && currX < map.length && currY < map[0].length) {
                    if(map[currX][currY] == -1) {
                        continue;
                    }
                    if(!check[currX][currY] && map[currX][currY] != 1 && (map[t.x][t.y] + 1 < map[currX][currY] || map[currX][currY] == 0)) {
                        visit.add(new Tomato(currX, currY));
                        map[currX][currY] = map[t.x][t.y] + 1;
                        check[currX][currY] = true;
                    }
                }
            }
        }
    }
}

class Tomato {
    int x;
    int y;
    public Tomato(int x, int y) {
        this.x = x;
        this.y = y;
    }
}