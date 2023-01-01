// 0ms. 예외 케이스 하나를 생각하지 못해서 한번 틀렸다... 이지 치고는 방심할 수 있는 문제인듯
class Solution {
    public boolean wordPattern(String pattern, String s) {
        int patternCount = 0;
        int wordCount = 0;
        Map<String, Character> patternMap = new HashMap<>();
        boolean[] usage = new boolean[26];

        String[] splited = s.split(" ");
        char[] patternChars = pattern.toCharArray();

        if (splited.length != patternChars.length) {
            return false;
        }

        for (int i = 0; i < patternChars.length; i++) {
            if (!patternMap.containsKey(splited[i])) {
                if (usage[patternChars[i] - 'a']) {
                    return false;
                }
                patternMap.put(splited[i], patternChars[i]);
                usage[patternChars[i] - 'a'] = true;
                continue;
            }

            char patternValue = patternMap.get(splited[i]);
            if (patternValue != patternChars[i]) {
                return false;
            }
        }
        return true;
    }
}
