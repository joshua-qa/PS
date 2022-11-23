// 1ms. 서브 사각형 구현이 조금 헷갈릴 수 있어서 한번 연습해두면 참 좋은 문제.
class Solution {
    public boolean isValidSudoku(char[][] board) {
        // 가로
        for (int i = 0; i < 9; i++) {
            boolean[] visit = new boolean[10];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int curr = board[i][j] - '0';
                if (visit[curr]) {
                    return false;
                }
                visit[curr] = true;
            }
        }
        // 세로
        for (int i = 0; i < 9; i++) {
            boolean[] visit = new boolean[10];
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.') {
                    continue;
                }
                int curr = board[j][i] - '0';
                if (visit[curr]) {
                    return false;
                }
                visit[curr] = true;
            }
        }
        // 서브 사각형
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boolean[] visit = new boolean[10];
                for (int k = 0; k < 9; k++) {
                    int currX = (i * 3) + (k / 3);
                    int currY = (j * 3) + (k % 3);
                    if (board[currX][currY] == '.') {
                        continue;
                    }
                    int curr = board[currX][currY] - '0';
                    if (visit[curr]) {
                        return false;
                    }
                    visit[curr] = true;
                }
            }
        }
        return true;
    }
}
