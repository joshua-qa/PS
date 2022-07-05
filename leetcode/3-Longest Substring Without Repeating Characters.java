/**
 * 4ms.. 정답률 낮은건 1페이지 문제라서 그런듯
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] count = new int[256];

        int length = s.length();
        char[] cs = s.toCharArray();

        int start = 0;
        int end = 0;
        int result = 0;
        while (end < length) {
            count[cs[end]]++;

            if (count[cs[end]] == 2) {
                int curr = end - start;
                result = result < curr ? curr : result;
                while (count[cs[end]] == 2) {
                    count[cs[start++]]--;
                }
            }
            end++;
        }
        int curr = end - start;
        result = result < curr ? curr : result;

        return result;
    }
}
