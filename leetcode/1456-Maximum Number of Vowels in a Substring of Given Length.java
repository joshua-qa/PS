// 11ms. 슬라이딩 윈도우 날먹
class Solution {
    public int maxVowels(String s, int k) {
        char[] cs = s.toCharArray();
        if (cs.length == 1) {
            return isVowel(cs[0]);
        }

        int start = 0, end = k-1, curr = 0;
        for (int i = start; i <= end; i++) {
            curr += isVowel(cs[i]);
        }
        int result = curr;
        for (int i = end+1; i < cs.length; i++) {
            end++;
            curr += (isVowel(cs[end]) - isVowel(cs[start]));
            if (result < curr) {
                result = curr;
            }
            start++;
        }
        return result;
    }

    private int isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') ? 1 : 0;
    }
}
