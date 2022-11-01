// 3ms. 설명이 좀 길긴 한데 직관적인 솔루션으로 접근하면 무난하다.
class Solution {
    public int[] findBall(int[][] grid) {
        int width = grid[0].length;
        int height = grid.length;

        int[] result = new int[width];

        for (int i = 0; i < width; i++) {
            int currX = 0;
            int currY = i;

            boolean isAvailable = true;
            while (currX < height) {
                if (grid[currX][currY] == 1) {
                    if (currY == width-1) {
                        isAvailable = false;
                        break;
                    }
                    if (grid[currX][currY+1] == -1) {
                        isAvailable = false;
                        break;
                    }
                    currX++;
                    currY++;
                } else {
                    if (currY == 0) {
                        isAvailable = false;
                        break;
                    }
                    if (grid[currX][currY-1] == 1) {
                        isAvailable = false;
                        break;
                    }
                    currX++;
                    currY--;
                }
            }
            result[i] = isAvailable ? currY : -1;
        }

        return result;
    }
}
