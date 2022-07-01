/**
 * 11ms.. 정해가 너무 짧아서 놀랬는데 접근 방법 자체는 비슷한듯
 */
class Solution {
    int strLength, patternSize;
    List<String> pattern;
    char[] str;
    boolean result;
    public boolean isMatch(String s, String p) {
        result = false;
        str = s.toCharArray();
        pattern = new ArrayList<>();
        int plen = p.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < plen; i++) {
            char curr = p.charAt(i);
            if (!stack.isEmpty() && curr == '*') {
                String currPattern = stack.pop() + "*";
                if (!pattern.isEmpty() && pattern.get(pattern.size()-1).equals(currPattern)) {
                    continue;
                }
                pattern.add(currPattern);
                continue;
            }
            if (!stack.isEmpty()) {
                pattern.add(String.valueOf(stack.pop()));
            }
            stack.push(curr);
        }
        if (!stack.isEmpty()) {
            pattern.add(String.valueOf(stack.pop()));
        }
        strLength = s.length();
        patternSize = pattern.size();
        dfs(0, 0);
        return result;
    }

    private void dfs(int index, int patternIndex) {
        if (index == strLength) {
            if (patternIndex == patternSize) {
                result = true;
            } else {
                if (pattern.get(patternIndex).length() == 2) {
                    dfs(index, patternIndex+1);
                }
            }
            return;
        }
        if (patternIndex == patternSize) {
            return;
        }
        String currentPattern = pattern.get(patternIndex);
        boolean isAsterisk = currentPattern.length() == 2;

        /**
         * case 1) 현재에 매칭되고 *이 없는 경우
         * -> 다음 인덱스 + 다음 패턴 탐색
         * case 2) 현재에 매칭되고 *이 있는 경우
         * -> 다음 인덱스 + 다음 패턴 탐색, 현재 인덱스 + 다음 패턴 탐색, 현재 패턴 한번 더 탐색
         * case 3) 현재에 매칭되지 않고, *이 없는 경우
         * -> return
         * case 4) 현재에 매칭되지 않고, *이 있는 경우
         * -> 현재 인덱스 + 다음 패턴 탐색
         */

        if (isMatch(str[index], currentPattern.charAt(0))) {
            if (isAsterisk) {
                dfs(index+1, patternIndex);
                dfs(index, patternIndex+1);
            }
            dfs(index+1, patternIndex+1);
        } else {
            if (isAsterisk) {
                dfs(index, patternIndex+1);
            }
        }
    }

    private boolean isMatch(char c, char p) {
        if (p == '.') {
            return true;
        }
        return c == p;
    }
}
