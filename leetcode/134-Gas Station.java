// 2ms. 문제를 잘못 읽고 접근하기도 했고, 처음 겪어보는 유형이라 너무 빡셌다. 이런거 아무렇지도 않게 풀어야 하는데...
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        int totalSum = 0;
        int currSum = 0;
        int startIndex = 0;
        for (int i = 0; i < length; i++) {
            totalSum += (gas[i] - cost[i]);
            currSum += gas[i];
            if (currSum < cost[i]) {
                startIndex = i+1;
                currSum = 0;
            } else {
                currSum -= cost[i];
            }
        }
        return totalSum < 0 ? -1 : startIndex;
    }
}
