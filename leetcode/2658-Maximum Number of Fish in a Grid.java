class Solution {
    private int[] dirX = {-1, 0, 0, 1};
    private int[] dirY = {0, -1, 1, 0};
    private boolean[][] visited;
    private int width, height, max;
    public int findMaxFish(int[][] grid) {
        width = grid[0].length;
        height = grid.length;
        visited = new boolean[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (visited[i][j] || grid[i][j] == 0) {
                    continue;
                }

                int result = dfs(grid, i, j);
                if (max < result) {
                    max = result;
                }
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int x, int y) {
        visited[x][y] = true;
        int score = grid[x][y];

        for (int i = 0; i < dirX.length; i++) {
            int currX = x + dirX[i];
            int currY = y + dirY[i];
            if (currX < 0 || currX == height || currY < 0 || currY == width) {
                continue;
            }

            if (!visited[currX][currY] && grid[currX][currY] != 0) {
                score += dfs(grid, currX, currY);
            }
        }

        return score;
    }
}
