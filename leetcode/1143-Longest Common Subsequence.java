// 13ms. LCS는 몇달 지나면 자꾸 까먹어서 살짝 애먹었다. 그런데 이번에 산 책에 설명이 잘 되어있어서 드디어 제대로 이해한듯!
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int text1Length = text1.length();
        int text2Length = text2.length();
        int[][] dp = new int[text1Length+1][text2Length+1];
        for (int i = 1; i <= text1Length; i++) {
            for (int j = 1; j <= text2Length; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[text1Length][text2Length];
    }
}
