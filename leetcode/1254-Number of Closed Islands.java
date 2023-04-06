// 1ms. 섬이 성립할 수 없는 조건을 생각하면 쉽다.
class Solution {
    private boolean flag;
    private int width, height;
    public int closedIsland(int[][] grid) {
        width = grid[0].length;
        height = grid.length;

        int result = 0;
        int group = 2;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] != 0) {
                    continue;
                }
                flag = true;
                dfs(i, j, group, grid);
                if (flag) {
                    result++;
                }
                group++;
            }
        }
        return result;
    }

    private void dfs(int x, int y, int group, int[][] grid) {
        if (x == 0 || x == height-1 || y == 0 || y == width-1) {
            flag = false;
        }

        grid[x][y] = group;
        if (x-1 >= 0 && grid[x-1][y] == 0) {
            dfs(x-1, y, group, grid);
        }

        if (y-1 >= 0 && grid[x][y-1] == 0) {
            dfs(x, y-1, group, grid);
        }

        if (y+1 < width && grid[x][y+1] == 0) {
            dfs(x, y+1, group, grid);
        }

        if (x+1 < height && grid[x+1][y] == 0) {
            dfs(x+1, y, group, grid);
        }
    }
}
