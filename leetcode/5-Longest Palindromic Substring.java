/**
 * 8ms 99.35%.. 최적화 더 할 수는 있을 거 같은데 스킵
 */
class Solution {
    int length;
    char[] chars;
    public String longestPalindrome(String s) {
        chars = s.toCharArray();
        length = chars.length;
        int maxLength = 1;
        int maxIndex = 0;
        for (int i = 0; i < length; i++) {
            int curr = getMaxPalindrome(i);
            if (curr > maxLength) {
                maxIndex = i;
                maxLength = curr;
            }
        }

        int halfLength = maxLength / 2;
        return (maxLength % 2 == 0) ? s.substring(maxIndex - halfLength + 1, maxIndex + halfLength + 1) : s.substring(maxIndex - halfLength, maxIndex + halfLength + 1);
    }

    private int getMaxPalindrome(int index) {
        int result = 1;
        for (int l = index-1, r = index+1; l >= 0 && r < length; l--, r++, result += 2) {
            if (chars[l] != chars[r]) {
                break;
            }
        }
        if (index != length-1 && chars[index] == chars[index+1]) {
            int anotherResult = 2;
            for (int l = index-1, r = index+2; l >= 0 && r < length; l--, r++, anotherResult += 2) {
                if (chars[l] != chars[r]) {
                    break;
                }
            }
            return anotherResult > result ? anotherResult : result;
        }
        return result;
    }
}