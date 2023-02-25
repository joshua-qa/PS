// 2ms. 스택을 써서 풀어도 되는데 이거보단 느리다.
class Solution {
    public int maxProfit(int[] prices) {
        int length = prices.length;

        int result = 0;
        int currMin = prices[0];
        for (int i = 1; i < length; i++) {
            if (prices[i] < currMin) {
                currMin = prices[i];
                continue;
            }

            if (result < prices[i] - currMin) {
                result = prices[i] - currMin;
            }
        }
        return result;
    }
}
