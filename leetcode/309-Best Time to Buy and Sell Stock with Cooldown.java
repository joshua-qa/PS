// 21ms. O(N^2) 풀이는 금방 생각해낼 수 있었는데 이걸 O(N)으로 줄이는 방법이 있다는걸 알았다.
// 관련 자료를 열심히 공부해서 다음에 또 다시 풀어봐야함.
// 관련 자료 : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/discuss/108870/Most-consistent-ways-of-dealing-with-the-series-of-stock-problems
class Solution {
    public int maxProfit(int[] prices) {
        int length = prices.length;

        int[] dp = new int[length];
        int profit = 0;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                int sum = prices[i] - prices[j];
                if (j - 2 >= 0) {
                    sum += dp[j-2];
                }
                dp[i] = Math.max(Math.max(dp[i-1],sum), dp[i]);
            }
        }
        for (int i = 0; i < length; i++) {
            if (dp[i] > profit) {
                profit = dp[i];
            }
        }
        return profit;
    }
}
