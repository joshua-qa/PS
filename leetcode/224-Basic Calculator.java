// 67ms. 어제보단 훨씬 할만한 하드여서 다행이었음. 음수 기호에 대해 좀더 영리하게 처리했으면 코드 짧아졌을듯
class Solution {
    public int calculate(String s) {
        Deque<String> stack = new ArrayDeque<>();

        char[] cs = s.toCharArray();
        int length = cs.length;
        long result = 0;

        for (int i = 0; i < length; i++) {
            switch (cs[i]) {
                case '(':
                    if (!stack.isEmpty() && stack.peek().equals("-")) {
                        stack.pop();
                        if (stack.isEmpty() || stack.peek().equals("(")) {
                            stack.push("u-");
                        } else {
                            stack.push("-");
                        }
                    }
                    stack.push("(");
                    break;
                case ')':
                    // 괄호 닫는 처리
                    String pop = stack.pop();
                    // ( 빼기
                    stack.pop();
                    if (stack.isEmpty()) {
                        stack.push(pop);
                        break;
                    }
                    if (stack.peek().equals("(")) {
                        stack.push(pop);
                        break;
                    }
                    long num = Long.parseLong(pop);
                    String peek = stack.pop();
                    if (peek.equals("+")) {
                        num = Long.parseLong(stack.pop()) + num;
                        stack.push(String.valueOf(num));
                        break;
                    }
                    if (peek.equals("-")) {
                        num = Long.parseLong(stack.pop()) - num;
                        stack.push(String.valueOf(num));
                        break;
                    }
                    if (peek.equals("u-")) {
                        stack.push(String.valueOf(-num));
                    }
                    break;
                case '+':
                    // 덧셈 처리
                    stack.push("+");
                    break;
                case '-':
                    stack.push("-");
                    break;
                case ' ':
                    break;
                default:
                    StringBuilder sb = new StringBuilder();
                    sb.append(cs[i]);
                    while (i+1 < length && isNumber(cs[i+1])) {
                        i++;
                        sb.append(cs[i]);
                    }
                    long currNum = Long.parseLong(sb.toString());
                    // 앞에 음수기호 있을 때 처리
                    if (!stack.isEmpty()) {
                        if (stack.peek().equals("-")) {
                            stack.pop();
                            if (!stack.isEmpty() && isNumber(stack.peek())) {
                                currNum = Long.parseLong(stack.pop()) - currNum;
                            } else {
                                currNum = -currNum;
                            }
                        } else if (stack.peek().equals("+")) {
                            stack.pop();
                            if (!stack.isEmpty() && isNumber(stack.peek())) {
                                currNum = Long.parseLong(stack.pop()) + currNum;
                            }
                        }
                    }
                    stack.push(String.valueOf(currNum));
                    break;
            }
        }
        long peek = Long.parseLong(stack.pop());
        return (int) peek;
    }

    private boolean isNumber(char c) {
        int num = c - '0';
        return num >= 0 && num < 10;
    }

    private boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
