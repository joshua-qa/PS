// 4ms. 이정도 dp는 보자마자 풀어줘야 제맛
// 사실 슬라이딩 윈도우까지 쓰는게 공간복잡도 면에서는 훨씬 낫다.
class Solution {
    private int[][] dp;
    private int minSum, size;
    public int minFallingPathSum(int[][] matrix) {
        minSum = Integer.MAX_VALUE;
        size = matrix.length;
        dp = new int[size][size];

        System.arraycopy(matrix[0], 0, dp[0], 0, size);

        for (int i = 1; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int leftDiagonal = (j-1 >= 0) ? dp[i-1][j-1] : 10000;
                int rightDiagonal = (j+1 < size) ? dp[i-1][j+1] : 10000;
                int prevMin = Math.min(Math.min(leftDiagonal, rightDiagonal), dp[i-1][j]);
                dp[i][j] = prevMin + matrix[i][j];
            }
        }
        for (int i = 0; i < size; i++) {
            minSum = Math.min(dp[size-1][i], minSum);
        }
        return minSum;
    }
}
