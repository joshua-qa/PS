// 4ms. 직관적으로 풀었는데 바로 맞았다.
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int popIndex = 0;
        Stack<Integer> stack = new Stack<>();
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popped[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }
}
