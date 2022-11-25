// 18ms. 상당히 까다로우면서 재밌는 문제였다.
// 미디엄이 아니라는 의견도 있는데.. Monotonic Stack + DP라서 그렇게 느끼는 걸지도 모르겠다. 꼭 풀어볼 가치가 있다.
class Solution {
    public int sumSubarrayMins(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        long mod = 1000000007;

        int end = arr.length-1;
        stack.push(end);
        long[] dp = new long[arr.length];
        long result = arr[end];
        dp[end] = result;
        for (int i = end-1; i >= 0; i--) {
            int peekIndex = stack.peek();
            if (arr[peekIndex] >= arr[i]) {
                while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                    stack.pop();
                }

                if (stack.isEmpty()) {
                    long curr = (long) (end - i + 1) * arr[i];
                    result += curr;
                    result %= mod;
                    dp[i] = curr;
                } else {
                    peekIndex = stack.peek();
                    long endSum = dp[peekIndex];
                    long peekSum = (long) (peekIndex - i) * arr[i];
                    result += endSum + peekSum;
                    result %= mod;
                    dp[i] = endSum + peekSum;
                }
            } else {
                long endSum = dp[peekIndex];
                long peekSum = (long) (peekIndex - i) * arr[i];
                result += endSum + peekSum;
                result %= mod;
                dp[i] = endSum + peekSum;
            }
            stack.push(i);
        }
        return (int) (result % mod);
    }
}
