// 2ms. 생각해내는데 20분 정도 걸렸으나 잘 풀어서 만족
class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        int length = s.length();
        int[] dp = new int[length];
        char[] cs = s.toCharArray();
        dp[length-1] = cs[length-1] == '0' ? 0 : 1;

        for (int i = length-2; i >= 0; i--) {
            int singleNum = cs[i] - '0';
            int doubleNum = singleNum * 10 + (cs[i+1] - '0');
            if (singleNum == 0) {
                continue;
            } else {
                dp[i] += dp[i+1];
            }
            if (doubleNum <= 26) {
                if (i+2 != length) {
                    dp[i] += dp[i + 2];
                } else {
                    dp[i]++;
                }
            }
        }
        return dp[0];
    }
}
