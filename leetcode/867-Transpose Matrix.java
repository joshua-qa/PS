class Solution {
    public int[][] transpose(int[][] matrix) {
        int[][] result = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length * matrix[0].length; i++) {
            result[i % matrix[0].length][i / matrix[0].length] = matrix[i / matrix[0].length][i % matrix[0].length];
        }
        return result;
    }
}
