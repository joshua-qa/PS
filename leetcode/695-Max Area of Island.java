/**
 * 11ms. 스택 터져서 bfs 썼는데 사실 dfs를 잘 짜면 되는거였음.
 */
class Solution {
    int width, height;
    private int[] dirX = {-1, 0, 0, 1};
    private int[] dirY = {0, -1, 1, 0};
    private int[][] visit;
    public int maxAreaOfIsland(int[][] grid) {
        width = grid.length;
        height = grid[0].length;
        int result = 0;
        int groupNo = 0;
        visit = new int[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (visit[i][j] == 0 && grid[i][j] == 1) {
                    bfs(i, j, ++groupNo, grid);
                }
            }
        }
        int[] count = new int[groupNo+1];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (visit[i][j] != 0) {
                    count[visit[i][j]]++;
                }
            }
        }

        for (int i = 1; i <= groupNo; i++) {
            if (result < count[i]) {
                result = count[i];
            }
        }
        return result;
    }

    private void bfs(int x, int y, int groupNo, int[][] grid) {
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(x, y));

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> node = queue.poll();
            if (visit[node.getKey()][node.getValue()] == 0) {
                visit[node.getKey()][node.getValue()] = groupNo;
            } else {
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int currX = node.getKey() + dirX[i];
                int currY = node.getValue() + dirY[i];
                if (currX >= 0 && currX < width && currY >= 0 && currY < height && visit[currX][currY] == 0 && grid[currX][currY] == 1) {
                    queue.offer(new Pair<>(currX, currY));
                }
            }
        }
    }
}
