import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private final int[] Dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    private final int[] Dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    Queue<Vertex> visit = new LinkedList<>();
    private boolean[][] check = new boolean[50][50];
    private int currX, currY;
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        StringTokenizer st;
        int w, h;
        int count;

        while(true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            count = 0;

            if(w == 0 && h == 0) {
                break;
            }

            int[][] map = new int[h][w];
            for(int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    if(!check[i][j] && map[i][j] == 1) {
                        bfs(i, j, map);
                        count++;
                    }
                }
            }

            sb.append(count + "\n");
            resetCheck(h);
        }

        System.out.print(sb.toString());
    }

    private void resetCheck(int h) {
        for(int i = 0; i < h; i++) {
            Arrays.fill(check[i], false);
        }
    }

    private void bfs(int i, int j, int[][] map) {
        check[i][j] = true;
        visit.add(new Vertex(i, j));

        while(!visit.isEmpty()) {
            Vertex t = visit.remove();

            for(int k = 0; k < Dx.length; k++) {
                currX = t.x+Dx[k];
                currY = t.y+Dy[k];
                if(currX < 0 || currY < 0 || currX >= map.length || currY >= map[0].length) {
                    continue;
                }

                if(!check[currX][currY] && map[currX][currY] == 1) {
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