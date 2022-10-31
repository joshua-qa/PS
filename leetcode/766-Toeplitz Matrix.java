// 1ms. 비슷한 문제 한번이라도 풀어봤으면 매우 쉬움.
class Solution {
    private int width, height;
    public boolean isToeplitzMatrix(int[][] matrix) {
        width = matrix[0].length;
        height = matrix.length;

        for (int i = height-1; i >= 0; i--) {
            if (!isAvailable(matrix, i, 0)) {
                return false;
            }
        }

        for (int i = 1; i < width; i++) {
            if (!isAvailable(matrix, 0, i)) {
                return false;
            }
        }

        return true;
    }

    private boolean isAvailable(int[][] matrix, int startX, int startY) {
        int currNum = matrix[startX][startY];
        while (startX != height && startY != width) {
            if (matrix[startX][startY] != currNum) {
                return false;
            }
            startX++;
            startY++;
        }
        return true;
    }
}
