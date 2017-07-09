import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private int[] Dx = {-1, 0, 0, 1};
    private int[] Dy = {0, -1, 1, 0};
    private int[][] map;
    private boolean[][] check;
    private ArrayList<Vertex> house = new ArrayList<>();
    private Queue<Vertex> visit = new LinkedList<>();
    private ArrayList<Integer> count = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int num = 0;
        char[] ca;

        map = new int[n][n];
        check = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            ca = br.readLine().toCharArray();
            for(int j = 0; j < n; j++) {
                map[i][j] = ca[j] - '0';
                if(map[i][j] == 1) {
                    house.add(new Vertex(i, j));
                }
            }
        }

        for(Vertex v : house) {
            if(!check[v.x][v.y]) {
                count.add(bfs(v.x, v.y, ++num));
            }
        }

        System.out.println(num);
        Collections.sort(count);
        for(int i : count) {
            System.out.println(i);
        }
    }

    private int bfs(int x, int y, int num) {
        visit.add(new Vertex(x, y));
        check[x][y] = true;
        int result = 1;
        int currX, currY;

        while(!visit.isEmpty()) {
            Vertex v = visit.remove();

            for(int i = 0; i < 4; i++) {
                currX = v.x+Dx[i];
                currY = v.y+Dy[i];
                if(currX < 0 || currY < 0 || currX >= check.length || currY >= check.length) {
                    continue;
                } else {
                    if(!check[currX][currY] && map[currX][currY] != 0) {
                        map[currX][currY] = num;
                        visit.add(new Vertex(currX, currY));
                        check[currX][currY] = true;
                        result++;
                    }
                }
            }
        }

        return result;
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