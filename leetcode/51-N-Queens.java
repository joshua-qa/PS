class Solution {
    List<List<String>> result = new ArrayList<>();
    boolean[][] board;
    public List<List<String>> solveNQueens(int n) {
        for (int i = 0; i < n; i++) {
            board = new boolean[n][n];
            dfs(n, 0, i);
        }
        return result;
    }

    private void dfs(int n, int x, int y) {
        board[x][y] = true;
        if (!check(n, x, y)) {
            board[x][y] = false;
            return;
        }
        if (x == n-1) {
            appendBoardString(n);
            board[x][y] = false;
            return;
        }
        for (int i = 0; i < n; i++) {
            dfs(n, x+1, i);
        }
        board[x][y] = false;
    }

    private boolean check(int n, int x, int y) {
        for (int i = 0; i < x; i++) {
            if (board[i][y]) {
                return false;
            }
            if (y - (x-i) >= 0 && y - (x-i) < n && board[i][y - (x-i)]) {
                return false;
            }
            if (y + (x-1) >= 0 && y + (x-i) < n && board[i][y + (x-i)]) {
                return false;
            }
        }
        return true;
    }

    private void appendBoardString(int n) {
        List<String> current = new ArrayList<>();
        char[] row = new char[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                row[j] = board[i][j] ? 'Q' : '.';
            }
            current.add(String.valueOf(row));
        }
        result.add(current);
    }
}
