import java.util.*;
class Solution {
    private static final int[] DIR_X = {-1, 0, 0, 1};
    private static final int[] DIR_Y = {0, -1, 1, 0};
    private static final int SIZE = 4;
    private int maxCardNumber, result;
    private int[][] cardPosition;
    public int solution(int[][] board, int r, int c) {
        result = Integer.MAX_VALUE;
        maxCardNumber = getMaxCardNumber(board);
        cardPosition = new int[maxCardNumber+1][2];
        for (int i = 1; i <= maxCardNumber; i++) {
            cardPosition[i][0] = -1;
            cardPosition[i][1] = -1;
        }
        writeCardPosition(board);

        permutationProcess(maxCardNumber, 0, r, c, board, new boolean[maxCardNumber+1]);
        return result;
    }

    private void permutationProcess(int remain, int currentDist, int currentX, int currentY, int[][] board, boolean[] visit) {
        if (remain == 0) {
            result = Math.min(result, currentDist);
            return;
        }

        for (int i = 1; i <= maxCardNumber; i++) {
            if (visit[i]) {
                continue;
            }
            visit[i] = true;
            int[][] newMap = copyMap(board);
            int firstCardX = cardPosition[i][0] / 4;
            int firstCardY = cardPosition[i][0] % 4;
            int secondCardX = cardPosition[i][1] / 4;
            int secondCardY = cardPosition[i][1] % 4;
            newMap[firstCardX][firstCardY] = 0;
            newMap[secondCardX][secondCardY] = 0;
            // first
            int dist = bfs(board, currentX, currentY, firstCardX, firstCardY);
            int afterSecond = bfs(board, firstCardX, firstCardY, secondCardX, secondCardY) + 2;
            permutationProcess(remain - 1, currentDist + dist + afterSecond, secondCardX, secondCardY, newMap, visit);

            // second
            dist = bfs(board, currentX, currentY, secondCardX, secondCardY);
            int secondCardResult = bfs(board, secondCardX, secondCardY, firstCardX, firstCardY) + 2;
            permutationProcess(remain - 1, currentDist + dist + secondCardResult, firstCardX, firstCardY, newMap, visit);

            visit[i] = false;
        }
    }

    private int bfs(int[][] board, int x, int y, int targetX, int targetY) {
        int[][] dist = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            Arrays.fill(dist[i], 987654321);
        }
        Queue<Move> queue = new LinkedList<>();
        dist[x][y] = 0;
        queue.offer(new Move(x, y, 0));
        while (!queue.isEmpty()) {
            Move move = queue.poll();
            if (move.getX() == targetX && move.getY() == targetY) {
                continue;
            }

            for (int i = 0; i < DIR_X.length; i++) {
                int currX = move.getX() + DIR_X[i];
                int currY = move.getY() + DIR_Y[i];
                if (!isAvailable(currX, currY)) {
                    continue;
                }

                int currDist = move.getDist();
                int ctrlPosition = getCtrlPosition(board, currX, currY, i);
                int ctrlX = ctrlPosition / 4;
                int ctrlY = ctrlPosition % 4;
                if (dist[currX][currY] > currDist + 1) {
                    dist[currX][currY] = currDist + 1;
                    queue.offer(new Move(currX, currY, currDist + 1));
                }
                if (!(ctrlX == currX && ctrlY == currY) && dist[ctrlX][ctrlY] > currDist + 1) {
                    dist[ctrlX][ctrlY] = currDist + 1;
                    queue.offer(new Move(ctrlX, ctrlY, currDist + 1));
                }
            }
        }

        return dist[targetX][targetY];
    }

    private int getMaxCardNumber(int[][] board) {
        int result = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] > result) {
                    result = board[i][j];
                }
            }
        }
        return result;
    }

    private void writeCardPosition(int[][] board) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                int number = board[i][j];
                if (number == 0) {
                    continue;
                }
                if (cardPosition[number][0] != -1) {
                    cardPosition[number][1] = (i * 4) + j;
                    continue;
                }
                cardPosition[number][0] = (i * 4) + j;
            }
        }
    }

    private boolean isAvailable(int x, int y) {
        return x >= 0 && x < SIZE && y >= 0 && y < SIZE;
    }

    private int getCtrlPosition(int[][] board, int x, int y, int dir) {
        if (board[x][y] != 0) {
            return (x * 4) + y;
        }
        while (isAvailable(x + DIR_X[dir], y + DIR_Y[dir])) {
            x += DIR_X[dir];
            y += DIR_Y[dir];
            if (board[x][y] != 0) {
                return (x * 4) + y;
            }
        }
        return (x * 4) + y;
    }

    private int[][] copyMap(int[][] board) {
        int[][] newMap = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            System.arraycopy(board[i], 0, newMap[i], 0, SIZE);
        }
        return newMap;
    }
}

class Move {
    private int x;
    private int y;
    private int dist;

    public Move(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDist() {
        return dist;
    }
}