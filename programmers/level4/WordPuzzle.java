/**
 * 프로그래머스 레벨4 단어 퍼즐 (2017 팁스타운)
 */
import java.util.*;
class Solution {
    public int solution(String[] strs, String t) {
        int length = t.length();
        int[] dp = new int[length + 1];
        Arrays.fill(dp, 1000000);
        dp[0] = 0;
        for (int i = 1; i <= length; i++) {
            for (String str : strs) {
                int strLength = str.length();
                if (strLength > i) {
                    continue;
                }

                if (!str.equals(t.substring(i - strLength, i))) {
                    continue;
                }

                dp[i] = Math.min(dp[i], dp[i - strLength] + 1);
            }
        }

        int answer = dp[length] >= 1000000 ? -1 : dp[length];
        return answer;
    }
}