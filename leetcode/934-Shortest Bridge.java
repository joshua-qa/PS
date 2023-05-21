// 120ms. 사소한 실수 때문에 한시간 넘게 잡아먹음... DFS랑 BFS 섞어서 풀면 되는 문제고 추후에 다시 풀어봐야할듯
class Solution {
    private int width, height, min;
    private int[] dirX = {-1, 0, 0, 1};
    private int[] dirY = {0, -1, 1, 0};
    private boolean[][] visit;
    public int shortestBridge(int[][] grid) {
        width = grid[0].length;
        height = grid.length;
        visit = new boolean[height][width];
        min = Integer.MAX_VALUE;

        boolean flag = true;
        for (int i = 0; i < height && flag; i++) {
            for (int j = 0; j < width && flag; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = -1;
                    mark(grid, i, j);
                    flag = false;
                    break;
                }
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = -2;
                } else if (grid[i][j] == 0) {
                    grid[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == -1 && !visit[i][j]) {
                    visit[i][j] = true;
                    bfs(grid, i, j);
                }
            }
        }
        System.out.println(Arrays.deepToString(grid));
        return min;
    }

    private void mark(int[][] grid, int x, int y) {
        if (x-1 >= 0 && grid[x-1][y] == 1) {
            grid[x-1][y] = -1;
            mark(grid, x-1, y);
        }

        if (y-1 >= 0 && grid[x][y-1] == 1) {
            grid[x][y-1] = -1;
            mark(grid, x, y-1);
        }

        if (x+1 < height && grid[x+1][y] == 1) {
            grid[x+1][y] = -1;
            mark(grid, x+1, y);
        }

        if (y+1 < width && grid[x][y+1] == 1) {
            grid[x][y+1] = -1;
            mark(grid, x, y+1);
        }
    }

    private void bfs(int[][] grid, int x, int y) {
        Queue<Point> queue = new LinkedList<>();

        queue.offer(new Point(x, y, 0));

        while (!queue.isEmpty()) {
            Point curr = queue.poll();

            for (int i = 0; i < dirX.length; i++) {
                int currX = dirX[i] + curr.getX();
                int currY = dirY[i] + curr.getY();
                if (currX < 0 || currX == height || currY < 0 || currY == width || grid[currX][currY] == -1) {
                    continue;
                }

                if (grid[currX][currY] == -2) {
                    min = Math.min(min, curr.getDist());
                    continue;
                }

                if (curr.getDist() + 1 < grid[currX][currY]) {
                    grid[currX][currY] = curr.getDist() + 1;
                    queue.offer(new Point(currX, currY, curr.getDist() + 1));
                }
            }
        }
    }
}

class Point {
    private int x;
    private int y;
    private int dist;

    public Point(int x, int y, int dist) {
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
