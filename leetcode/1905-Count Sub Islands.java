class Solution {
    private boolean flag;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        // dfs
        for (int i = 0; i < grid1.length; i++) {
            for (int j = 0; j < grid1[0].length; j++) {
                if (grid1[i][j] == 0 && grid2[i][j] == 1) {
                    grid1[i][j] = 1;
                } else if (grid1[i][j] == 1 && grid2[i][j] == 1) {
                    grid1[i][j] = 2;
                } else {
                    grid1[i][j] = 0;
                }
                grid2[i][j] = 0;
            }
        }

        int count = 0;
        for (int i = 0; i < grid1.length; i++) {
            for (int j = 0; j < grid1[0].length; j++) {
                if (grid1[i][j] == 0 || grid2[i][j] == 1) {
                    continue;
                }
                flag = true;
                dfs(grid1, grid2, i, j);
                if (flag) {
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int[][] grid, int[][] visit, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] == 0 || visit[i][j] == 1) {
            return;
        }
        if (grid[i][j] == 1) {
            flag = false;
        }
        visit[i][j] = 1;
        dfs(grid, visit, i + 1, j);
        dfs(grid, visit, i - 1, j);
        dfs(grid, visit, i, j + 1);
        dfs(grid, visit, i, j - 1);
    }
}
