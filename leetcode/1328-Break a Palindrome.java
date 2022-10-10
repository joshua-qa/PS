// 0ms. 문제에 주어진 조건을 정확하게 해석해서 풀어야함. 고려해야할 케이스도 여러가지.
class Solution {
    public String breakPalindrome(String palindrome) {
        char[] cs = palindrome.toCharArray();
        int length = cs.length;
        if (length == 1) {
            return "";
        }
        if ((length & 1) == 1) {
            int half = length / 2;
            for (int i = 0; i < length; i++) {
                if (cs[i] != 'a' && i != half) {
                    cs[i] = 'a';
                    return new String(cs);
                }
            }
        } else {
            for (int i = 0; i < length; i++) {
                if (cs[i] != 'a') {
                    cs[i] = 'a';
                    return new String(cs);
                }
            }
        }
        cs[length-1] = 'b';
        return new String(cs);
    }
}
