// 1ms. 나름 재밌었다.
class Solution {
    private char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
    public boolean halvesAreAlike(String s) {
        int length = s.length();
        char[] cs = s.toCharArray();

        int aVowel = 0, bVowel = 0;
        int start = 0, end = length-1;
        while (start < end) {
            if (isVowel(cs[start++])) {
                aVowel++;
            }
            if (isVowel(cs[end--])) {
                bVowel++;
            }
        }
        return aVowel == bVowel;
    }

    private boolean isVowel(char c) {
        for (int i = 0; i < 10; i++) {
            if (vowels[i] == c) {
                return true;
            }
        }
        return false;
    }
}
