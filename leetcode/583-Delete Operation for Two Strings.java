/**
 * LCS 코드는 까먹기 쉬운 것 같다... 8ms
 */
class Solution {
    public int minDistance(String word1, String word2) {
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int chars1len = chars1.length;
        int chars2len = chars2.length;
        int[][] dp = new int[chars1len+1][chars2len+1];
        for (int i = 1; i <= chars1len; i++) {
            for (int j = 1; j <= chars2len; j++) {
                if (chars1[i-1] == chars2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = dp[i-1][j] >= dp[i][j-1] ? dp[i-1][j] : dp[i][j-1];
                }
            }
        }
        int result = dp[chars1len][chars2len];
        return chars1len + chars2len - (result * 2);
    }
}
