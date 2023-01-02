// 1ms. 그냥 쉽게 접근했다. 정규식 쓰는 방법도 있었네
class Solution {
    public boolean detectCapitalUse(String word) {
        int capitalCount = 0;
        for (char c : word.toCharArray()) {
            if (c - 'A' >= 0 && c - 'A' < 26) {
                capitalCount++;
            }
        }
        int firstChar = word.charAt(0) - 'A';
        return capitalCount == 0 || capitalCount == word.length() ||
                capitalCount == 1 && (firstChar >= 0 && firstChar < 26);
    }
}
