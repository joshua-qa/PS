// 4ms. 익숙한 그 문제..
class Solution {
    private boolean[][] visit;
    private int w, h;
    public int numIslands(char[][] grid) {    
        w = grid[0].length;
        h = grid.length;
        visit = new boolean[h][w];
        int count = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (!visit[i][j] && grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int x, int y) {
        if (x < 0 || x >= h || y < 0 || y >= w) {
            return;
        }
        if (visit[x][y] || grid[x][y] == '0') {
            return;
        }
        visit[x][y] = true;

        dfs(grid, x-1, y);
        dfs(grid, x+1, y);
        dfs(grid, x, y-1);
        dfs(grid, x, y+1);
    }
}
