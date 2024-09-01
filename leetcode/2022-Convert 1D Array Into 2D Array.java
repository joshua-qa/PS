class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length > m * n || original.length % (m * n) != 0) {
            return new int[][]{};
        }

        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0, k = i * n; j < n && k < original.length; j++, k++) {
                result[i][j] = original[k];
            }
        }
        return result;
    }
}
