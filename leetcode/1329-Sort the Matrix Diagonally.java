// 3ms. 난이도가 어려운건 아닌데 배열 조작 많이 안해봤으면 헤맬 수 있음
class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int x = mat.length;
        int y = mat[0].length;

        // x = 3, y = 4, currX = 0, currY = 3
        int currY = y-1;
        int[] count = new int[101];
        while (currY > 0) {
            for (int i = 0, j = currY; i < x && j < y; i++, j++) {
                int num = mat[i][j];
                count[num]++;
            }

            for (int i = 0, j = currY, num = 1; i < x && j < y; i++, j++) {
                while (num < 100 && count[num] == 0) {
                    num++;
                }
                count[num]--;
                mat[i][j] = num;
            }
            currY--;
            Arrays.fill(count, 0);
        }

        int currX = 0;
        while (currX < x) {
            for (int i = currX, j = 0; i < x && j < y; i++, j++) {
                int num = mat[i][j];
                count[num]++;
            }

            for (int i = currX, j = 0, num = 1; i < x && j < y; i++, j++) {
                while (num < 100 && count[num] == 0) {
                    num++;
                }
                count[num]--;
                mat[i][j] = num;
            }
            currX++;
            Arrays.fill(count, 0);
        }
        return mat;
    }
}
