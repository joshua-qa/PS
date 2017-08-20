import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    int[][] map = new int[10][10];
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < map.length; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < map[0].length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        go(1, 1);

        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[0].length; j++) {
                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    private void go(int x, int y) {
        if(map[x][y+1] == 1 && map[x+1][y] == 1) {
            map[x][y] = 9;
            return;
        } else if(map[x][y] == 2) {
            map[x][y] = 9;
            return;
        }

        map[x][y] = 9;

        if(map[x][y+1] == 0) {
            go(x, y+1);
        } else {
            go(x+1, y);
        }
    }
}