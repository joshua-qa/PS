import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Created by jgchoi.qa on 2017. 8. 24..
 */

public class Solution {
    static int[] Dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] Dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int count;
    static boolean[][] visit;
    public static int getBiggestRegion(int[][] matrix) {
        int ans = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(!visit[i][j] && matrix[i][j] == 1) {
                    count = 0;
                    dfs(i, j, matrix);
                    ans = Math.max(ans, count);
                }
            }
        }
        return ans;
    }

    private static void dfs(int x, int y, int[][] matrix) {
        visit[x][y] = true;
        count++;
        for(int i = 0; i < Dx.length; i++) {
            int currX = x + Dx[i];
            int currY = y + Dy[i];
            if(currX < 0 || currX >= matrix.length || currY < 0 || currY >= matrix[0].length) {
                continue;
            }
            if(matrix[currX][currY] == 1 && !visit[currX][currY]) {
                dfs(currX, currY, matrix);
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < m; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }

        visit = new boolean[n][m];
        System.out.println(getBiggestRegion(grid));
    }
}
