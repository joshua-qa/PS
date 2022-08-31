// 708ms. 추후에 다시 풀어보긴 해야되는데 코드가 너무 길어져서 좀 그렇네..
class Solution {
    private char[][] dp;
    private boolean[][] visit;
    private int w, h;
    private int[] dirX = {-1, 0, 0, 1};
    private int[] dirY = {0, -1, 1, 0};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        w = heights[0].length;
        h = heights.length;
        dp = new char[h][w];
        visit = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            dp[i][0] = 'P';
            dp[i][w-1] = 'A';
        }
        for (int j = 0; j < w; j++) {
            dp[0][j] = 'P';
            dp[h-1][j] = 'A';
        }
        dp[0][w-1] = 'B';
        dp[h-1][0] = 'B';

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                dfs(heights, i, j);
                for (int k = 0; k < h; k++) {
                    Arrays.fill(visit[k], false);
                }
            }
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (dp[i][j] == 'B') {
                    List<Integer> pair = new ArrayList<>();
                    pair.add(i);
                    pair.add(j);
                    result.add(pair);
                }
            }
        }
        return result;
    }

    private char dfs(int[][] heights, int x, int y) {
        boolean isA = false;
        boolean isP = false;
        visit[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int currX = x + dirX[i];
            int currY = y + dirY[i];
            if (currX < 0 || currY < 0) {
                isP = true;
                continue;
            }

            if (currX == h || currY == w) {
                isA = true;
                continue;
            }

            if (heights[x][y] < heights[currX][currY]) {
                continue;
            }

            char curr = 'X';
            if (visit[currX][currY]) {
                curr = dp[currX][currY];
            } else {
                curr = dfs(heights, currX, currY);
            }
            if (curr == 'A') {
                isA = true;
            }
            if (curr == 'P') {
                isP = true;
            }
            if (curr == 'B') {
                isA = true;
                isP = true;
            }
        }
        dp[x][y] = 'X';
        if (isA && isP) {
            dp[x][y] = 'B';
        } else if (isA) {
            dp[x][y] = 'A';
        } else if (isP) {
            dp[x][y] = 'P';
        }
        return dp[x][y];
    }
}
