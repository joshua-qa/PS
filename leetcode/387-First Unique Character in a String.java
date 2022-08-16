// 4ms.
class Solution {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        char[] cs = s.toCharArray();
        for (char c : cs) {
            count[c - 'a']++;
        }
        for (int i = 0; i < cs.length; i++) {
            if (count[cs[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
