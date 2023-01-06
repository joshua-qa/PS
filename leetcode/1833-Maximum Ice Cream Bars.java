// 18ms. O(n log n)으로 풀어도 통과하지만 O(n)으로 최적화가 가능하다. 미디엄이라 하기엔 너무 쉬운듯
class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int[] count = new int[100001];
        for (int i = 0; i < costs.length; i++) {
            count[costs[i]]++;
        }

        int result = 0;
        for (int i = 0; i <= 100000; i++) {
            int multiple = i * count[i];
            if (coins < multiple) {
                result += (coins / i);
                break;
            }
            coins -= multiple;
            result += count[i];
        }
        return result;
    }
}
