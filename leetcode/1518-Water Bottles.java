class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int drinkCount = numBottles;

        while (numBottles / numExchange > 0) {
            drinkCount += numBottles / numExchange;
            numBottles = (numBottles / numExchange) + (numBottles % numExchange);
        }

        return drinkCount;
    }
}
