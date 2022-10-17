// 1ms. 쉬운 문제
class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean[] exist = new boolean[26];
        int result = 26;
        int length = sentence.length();
        char[] cs = sentence.toCharArray();
        for (int i = 0; i < length; i++) {
            int c = cs[i] - 'a';
            if (exist[c]) {
                continue;
            }
            exist[c] = true;
            result--;
            if (result == 0) {
                return true;
            }
        }
        return result == 0;
    }
}
