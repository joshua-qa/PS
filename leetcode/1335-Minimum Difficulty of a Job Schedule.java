// 362ms. 하드인데 풀었다는 것에 의의를 둔다
class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int jdLength = jobDifficulty.length;
        if (jdLength < d) {
            return -1;
        }
        int[][] maxTable = new int[jdLength+1][jdLength+1];
        for (int i = 1; i <= jdLength; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j <= jdLength; j++) {
                if (max < jobDifficulty[j-1]) {
                    max = jobDifficulty[j-1];
                }
                maxTable[i][j] = max;
            }
        }
        if (d == 1) {
            return maxTable[1][jdLength];
        }

        int[][][] dp = new int[d+1][jdLength+1][jdLength+1];
        int result = 3000001;

        for (int i = 0; i <= d; i++) {
            for (int j = 0; j <= jdLength; j++) {
                Arrays.fill(dp[i][j], result);
            }
        }

        for (int i = 1; i <= d; i++) {
            int startRange = (i == 1) ? i : jdLength;
            for (int j = i; j <= startRange; j++) {
                int endBegin = (i == d) ? jdLength : j;
                for (int k = endBegin; k <= jdLength; k++) {
                    int currMaxJd = maxTable[j][k];
                    if (i == 1) {
                        dp[i][j][k] = currMaxJd;
                        continue;
                    }

                    for (int l = i-1; l < j; l++) {
                        int sum = dp[i-1][l][j-1] + currMaxJd;
                        if (dp[i][j][k] > sum) {
                            dp[i][j][k] = sum;
                        }
                    }

                    if (i == d) {
                        if (result > dp[i][j][k]) {
                            result = dp[i][j][k];
                        }
                    }
                }
            }
        }

        return result;
    }
}
