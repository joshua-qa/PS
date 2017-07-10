import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private int[] Dx = {-1, 0, 0, 1};
    private int[] Dy = {0, -1, 1, 0};
    private int[][] map = new int[50][50];
    private boolean[][] check = new boolean[50][50];
    private StringTokenizer st;
    private Queue<Vertex> visit = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int m,n,k,x,y,count;
        StringBuffer sb = new StringBuffer();

        for(int a = 0; a < t; a++) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            for(int i = 0; i < map.length; i++) {
                Arrays.fill(map[i], 0);
                Arrays.fill(check[i], false);
            }
            ArrayList<Vertex> cList = new ArrayList<>();

            count = 0;
            for(int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());

                map[x][y] = 1;
                cList.add(new Vertex(x, y));
            }

            for(int i = 0; i < k; i++) {
                Vertex curr = cList.get(i);

                if(!check[curr.x][curr.y]) {
                    bfs(curr.x, curr.y);
                    count++;
                }
            }
            sb.append(count + "\n");
        }

        System.out.print(sb.toString());
    }

    private void bfs(int x, int y) {
        visit.add(new Vertex(x, y));
        check[x][y] = true;
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
                        visit.add(new Vertex(currX, currY));
                        check[currX][currY] = true;
                    }
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