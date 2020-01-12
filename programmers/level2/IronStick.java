public int solution(String arrangement) {
    int answer = 0;
    int length = arrangement.length();
    Stack<Character> stack = new Stack<>();

    int currentStick = 0;
    char prevChar = 0;
    for (int i = 0; i < length; i++) {
        char currentParen = arrangement.charAt(i);
        if (currentParen == '(') {
            stack.push(currentParen);
            if (!stack.isEmpty() && prevChar == '(') {
                currentStick++;
            }
        } else {
            stack.pop();
            if (prevChar == '(') {
                answer += currentStick;
            } else if (prevChar == ')') {
                currentStick--;
                answer++;
            }
        }
        prevChar = currentParen;
    }
    return answer;
}