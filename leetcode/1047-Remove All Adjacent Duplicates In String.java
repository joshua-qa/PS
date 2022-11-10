// 19ms. 살짝 쉬운 미디엄에 가까운 이지..
class Solution {
    public String removeDuplicates(String s) {
        char[] cs = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < cs.length; i++) {
            if (stack.isEmpty()) {
                stack.push(cs[i]);
                continue;
            }
            if (stack.peek() == cs[i]) {
                stack.pop();
                continue;
            }
            stack.push(cs[i]);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }
}
