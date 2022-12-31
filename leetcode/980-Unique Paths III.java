// 1ms. 대체 누가 이걸 하드로 매긴걸까... 코드가 조금 길게 나올 뿐 전혀 하드가 아닌데🙄
// 그래도 올해 마지막 날 기분 좋게 마무리한다!
class Solution {
    private int count, width, height, startX, startY, endX, endY, obstacleCount, visitableCount;
    private int[] dirX = {-1, 0, 0, 1};
    private int[] dirY = {0, -1, 1, 0};
    private boolean[][] visit;
    public int uniquePathsIII(int[][] grid) {
        width = grid[0].length;
        height = grid.length;
        visit = new boolean[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                switch (grid[i][j]) {
                    case -1:
                        obstacleCount++;
                        continue;
                    case 1:
                        startX = i;
                        startY = j;
                        continue;
                    case 2:
                        endX = i;
                        endY = j;
                        continue;
                    default:
                        continue;
                }
            }
        }
        visitableCount = (width * height) - obstacleCount;
        visit[startX][startY] = true;
        dfs(grid, startX, startY, 1);

        return count;
    }

    private void dfs(int[][] grid, int x, int y, int currVisitCount) {
        if (x == endX && y == endY) {
            if (visitableCount == currVisitCount) {
                count++;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int currX = x + dirX[i];
            int currY = y + dirY[i];
            if (currX < 0 || currX == height || currY < 0 || currY == width) {
                continue;
            }
            if (grid[currX][currY] == -1 || visit[currX][currY]) {
                continue;
            }

            visit[currX][currY] = true;
            dfs(grid, currX, currY, currVisitCount+1);
            visit[currX][currY] = false;
        }
    }
}
