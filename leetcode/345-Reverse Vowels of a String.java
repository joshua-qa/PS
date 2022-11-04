// 14ms. 비추수가 왜 많나 했더니..
class Solution {
    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        char[] cs = s.toCharArray();
        for (char c : cs) {
            if (isVowel(c)) {
                stack.push(c);
            }
        }

        for (char c : cs) {
            if (isVowel(c)) {
                sb.append(stack.pop());
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
            || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
