import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private int h, w, cnt;
    private char[][] map;
    private boolean[] check = new boolean[26];
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

        for(int i = 0; i < h; i++) {
            map[i] = br.readLine().toCharArray();
        }

        dfs(map, check, 0, 0, 0);
        System.out.print(cnt);
    }

    private int dfs(char[][] map, boolean[] check, int x, int y, int count) {
        if(x < 0 || x >= map.length || y < 0 || y >= map[0].length || check[map[x][y] - 'A']) {
            return count;
        }

        int curr = map[x][y] - 'A';
        for(int i = 0; i < Dx.length; i++) {
            check[curr] = true;
            int temp = dfs(map, check, x+Dx[i], y+Dy[i], count+1);
            check[curr] = false;
            if(temp > cnt) {
                cnt = temp;
            }
        }

        return cnt;
    }
}