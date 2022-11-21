// 24ms. 아마 dfs로도 가능할거고 전형적인 미로 문제
class Solution {
    int width, height;
    public int nearestExit(char[][] maze, int[] entrance) {
        int result = 987654321;
        int[] dirX = {-1, 0, 0, 1};
        int[] dirY = {0, -1, 1, 0};
        width = maze[0].length;
        height = maze.length;
        int[][] visit = new int[height][width];
        for (int i = 0; i < height; i++) {
            Arrays.fill(visit[i], 987654321);
        }
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(entrance[0], entrance[1], 0));
        visit[entrance[0]][entrance[1]] = 0;

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (isBorder(p.x, p.y) && !(p.x == entrance[0] && p.y == entrance[1])) {
                result = Math.min(result, p.move);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int currX = p.x + dirX[i];
                int currY = p.y + dirY[i];

                if (currX < 0 || currX == height || currY < 0 || currY == width || maze[currX][currY] == '+' || visit[currX][currY] <= p.move+1) {
                    continue;
                }

                visit[currX][currY] = p.move+1;
                queue.add(new Point(currX, currY, p.move+1));
            }
        }
        return result == 987654321 ? -1 : result;
    }

    private boolean isBorder(int x, int y) {
        return x == 0 || x == height-1 || y == 0 || y == width-1;
    }

    class Point {
        int x;
        int y;
        int move;
        public Point(int x, int y, int move) {
            this.x = x;
            this.y = y;
            this.move = move;
        }
    }
}
