// 1ms. 무난하게 푼듯
class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        int[] p = transformPattern(pattern);
        List<String> result = new ArrayList<>();

        for (String word : words) {
            int[] w = transformPattern(word);
            boolean isMatch = true;
            for (int i = 0; i < w.length; i++) {
                if (p[i] != w[i]) {
                    isMatch = false;
                }
            }
            if (isMatch) {
                result.add(word);
            }
        }
        return result;
    }

    private int[] transformPattern(String pattern) {
        int patternLength = pattern.length();
        int[] patternChars = new int[patternLength];
        for (int i = 0, j = 1; i < patternLength; i++) {
            if (patternChars[i] != 0) {
                continue;
            }
            char temp = pattern.charAt(i);
            patternChars[i] = j;
            for (int k = i+1; k < patternLength; k++) {
                if (pattern.charAt(k) == temp) {
                    patternChars[k] = j;
                }
            }
            j++;
        }
        return patternChars;
    }
}
