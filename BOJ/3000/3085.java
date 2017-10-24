import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    int n, max, temp, currX, currY;
    int[] Dx = {-1, 0, 0, 1};
    int[] Dy = {0, -1, 1, 0};
    int[][] map;
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for(int i = 0; i < n; i++) {
            char[] ca = br.readLine().toCharArray();
            for(int j = 0; j < n; j++) {
                map[i][j] = ca[j] == 'C' ? 0 : ca[j] == 'P' ? 1 : ca[j] == 'Z' ? 2 : 3;
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                check(i, j);
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                go(i, j);
            }
        }

        System.out.print(max);
    }

    private void go(int x, int y) {
        for(int i = 0; i < Dx.length; i++) {
            currX = x + Dx[i];
            currY = y + Dy[i];
            if(currX < 0 || currX >= n || currY < 0 || currY >= n) {
                continue;
            } else {
                swap(x, y, currX, currY);
                check(x, y);
                swap(x, y, currX, currY);
            }
        }
    }

    private void swap(int x, int y, int currX, int currY) {
        temp = map[x][y];
        map[x][y] = map[currX][currY];
        map[currX][currY] = temp;
    }

    private void check(int x, int y) {
        int xCount = 1, yCount = 1;
        for(int i = 1; i < n; i++) {
            if(map[x][i] == map[x][i-1]) {
                xCount++;
            } else {
                max = Math.max(xCount, max);
                xCount = 1;
            }
            if(map[i][y] == map[i-1][y]) {
                yCount++;
            } else {
                max = Math.max(yCount, max);
                yCount = 1;
            }
        }
        max = Math.max(Math.max(xCount, yCount), max);
    }
}