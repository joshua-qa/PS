// 154ms. DP 쓰면 더 빠른데 그 방식으로는 다음에 풀어보는걸로..
class Solution {
    private boolean[][] visit;
    private int[] dirX = {-1, 0, 0, 1};
    private int[] dirY = {0, -1, 1, 0};
    private int width, height;
    private boolean isExist;
    public boolean exist(char[][] board, String word) {
        height = board.length;
        width = board[0].length;
        visit = new boolean[height][width];
        isExist = false;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (isExist) {
                    return true;
                }

                if (board[i][j] != word.charAt(0)) {
                    continue;
                }
                visit[i][j] = true;
                dfs(board, word, i, j, 0);
                visit[i][j] = false;
            }
        }
        return isExist;
    }

    private void dfs(char[][] board, String word, int x, int y, int currIndex) {
        if (currIndex+1 == word.length()) {
            isExist = true;
            return;
        }

        if (isExist) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            int currX = x + dirX[i];
            int currY = y + dirY[i];
            if (currX < 0 || currX == height || currY < 0 || currY == width || visit[currX][currY]) {
                continue;
            }
            if (board[currX][currY] != word.charAt(currIndex+1)) {
                continue;
            }

            visit[currX][currY] = true;
            dfs(board, word, currX, currY, currIndex+1);
            visit[currX][currY] = false;
        }
    }
}
