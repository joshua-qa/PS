// 26ms. 전형적인 스택 문제. 더 빠르게 하려면 스택을 안쓰고 맨 뒤부터 배열 순회 하는 식으로 처리 가능하더라.
// 그런데 이번달은 왜 주말에 하드 문제가 안나오지?
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int length = temperatures.length;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }
            while (!stack.isEmpty()) {
                int peek = stack.peek();
                if (temperatures[i] > temperatures[peek]) {
                    result[peek] = i - peek;
                    stack.pop();
                } else {
                    break;
                }
            }
            stack.push(i);
        }

        return result;
    }
}
