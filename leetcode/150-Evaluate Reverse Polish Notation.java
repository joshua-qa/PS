// 4ms. 솔직히 이정도 난이도는 이지라고 봐야함.
// 처음 푸는 사람들이 낚일만한 요소가 있긴 있어서 정답률이 낮은 것 같은데 연습해둬서 나쁠건 없다.
// 이런 문제는 최종 정답이 int라 할지라도 중간 계산에서 벌어질 일들을 생각하여 long으로 연산하는게 좋은 것 같음.
class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Long> stack = new ArrayDeque<>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                    long first = stack.pop();
                    long second = stack.pop();
                    stack.push(first + second);
                    continue;
                case "-":
                    first = stack.pop();
                    second = stack.pop();
                    stack.push(second - first);
                    continue;
                case "*":
                    first = stack.pop();
                    second = stack.pop();
                    stack.push(first * second);
                    continue;
                case "/":
                    first = stack.pop();
                    second = stack.pop();
                    stack.push(second / first);
                    continue;
                default:
                    long num = Long.parseLong(token);
                    stack.push(num);
            }
        }
        long result = stack.pop();
        return (int) result;
    }
}
