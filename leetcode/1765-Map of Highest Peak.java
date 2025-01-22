class Solution {
    private int[] dirX = {-1, 0, 0, 1};
    private int[] dirY = {0, -1, 1, 0};
    private int[][] result;
    private int m, n;
    private Queue<Pair<Integer, Integer>> queue;
    public int[][] highestPeak(int[][] isWater) {
        // flood fill?
        m = isWater.length;
        n = isWater[0].length;
        result = new int[m][n];
        queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    queue.add(new Pair<>(i, j));
                }
            }
        }

        bfs(isWater);
        return result;
    }

    private void bfs(int[][] isWater) {
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> curr = queue.poll();

            for (int i = 0; i < 4; i++) {
                int currX = curr.getKey() + dirX[i];
                int currY = curr.getValue() + dirY[i];

                if (currX < 0 || currY < 0 || currX >= m || currY >= n) {
                    continue;
                }

                if (isWater[currX][currY] == 1) {
                    continue;
                }

                if (result[currX][currY] != 0) {
                    continue;
                }

                result[currX][currY] = result[curr.getKey()][curr.getValue()] + 1;
                queue.add(new Pair<>(currX, currY));
            }
        }
    }
}
