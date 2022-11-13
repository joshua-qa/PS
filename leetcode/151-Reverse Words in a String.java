// 5ms. 이제 이정도 미디엄은 바로바로 푸는듯?
class Solution {
    public String reverseWords(String s) {
        Deque<String> stack = new ArrayDeque<>();
        char[] cs = s.toCharArray();
        int index = 0;
        while (index < cs.length) {
            while (index != cs.length && cs[index] == ' ') {
                index++;
            }

            int start = index;
            while (index != cs.length && cs[index] != ' ') {
                index++;
            }
            stack.push(s.substring(start, index));
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        return sb.toString().trim();
    }
}
