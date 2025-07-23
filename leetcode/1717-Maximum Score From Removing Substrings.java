import java.util.*;
class Solution {
    private int result, xScore, yScore;
    private char[] xOp = {'a', 'b'};
    private char[] yOp = {'b', 'a'};
    private Deque<Character> stack = new ArrayDeque<>();
    public int maximumGain(String s, int x, int y) {
        char[] start = x > y ? xOp : yOp;
        xScore = x;
        yScore = y;
        rec(s.toCharArray(), x > y ? true : false, start);
        return result;
    }

    private void rec(char[] curr, boolean isX, char[] op) {
        for (char c : curr) {
            if (stack.isEmpty()) {
                stack.offerLast(c);
                continue;
            }

            char peek = stack.peekLast();
            if (peek == op[0] && c == op[1]) {
                stack.pollLast();
                int score = isX ? xScore : yScore;
                result += score;
                continue;
            }

            stack.offerLast(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollFirst());
        }

        char[] nextOp = isX ? yOp : xOp;
        if (sb.indexOf("ab") >= 0 || sb.indexOf("ba") >= 0) {
            rec(sb.toString().toCharArray(), isX ? false : true, nextOp);
        }
    }
}
