// 190ms. 무난한 문제.. 미디엄 치고는 너무 쉬운듯
class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c != '*') {
                stack.push(c);
                continue;
            }

            stack.pop();
        }

        StringBuilder sb = new StringBuilder(stack.size());
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
