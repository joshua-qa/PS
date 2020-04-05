public class Solution {

    public static void main(String[] args) {
      new Solution().run();
    }

    private void run() {
        int[] example = {7, 1, 5, 3, 6, 4};
        int[] example2 = {1, 2, 3, 4, 5};
        int[] example3 = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(example));
        System.out.println(maxProfit(example2));
        System.out.println(maxProfit(example3));
    }

    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }
        int min = 0, max = 0, currentProfit = 0, result = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[max] >= prices[i]) {
                result += currentProfit;
                currentProfit = 0;
                max = i;
                min = i;
                continue;
            }
            if (prices[max] < prices[i]) {
                currentProfit = prices[i] - prices[min];
                max = i;
            }
        }
        if (max < prices.length && prices[max] > prices[min]) {
            result += prices[max] - prices[min];
        }
        return result;
    }
}
