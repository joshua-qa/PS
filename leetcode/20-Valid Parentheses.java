// 2ms. 데일리 문제로 나와서 오랜만에 다시 풀었더니 코드가 살짝 바꼈는데 기존이랑 거의 비슷해서 신기
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }
            if (stack.isEmpty() || !check(stack.peek(), c)) {
                return false;
            }
            stack.pop();
        }
        return stack.isEmpty();
    }

    private boolean check(char peek, char curr) {
        return (peek == '[' && curr == ']') || (peek == '(' && curr == ')') || (peek == '{' && curr == '}');
    }
}
