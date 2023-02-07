// 7ms. 다행히 O(N) 해법을 금방 찾음
class Solution {
    public int totalFruit(int[] fruits) {
        int length = fruits.length;
        if (length < 3) {
            return length;
        }
        int[] count = new int[length];
        count[fruits[0]]++;
        count[fruits[1]]++;
        int currFruitCount = (fruits[0] == fruits[1]) ? 1 : 2;
        int firstFruit = fruits[0];
        int secondFruit = (fruits[0] == fruits[1]) ? -1 : fruits[1];
        int tail = 0;
        int result = 2;
        for (int i = 2; i < length; i++) {
            int currFruit = fruits[i];
            if (currFruitCount == 1) {
                count[currFruit]++;
                if (currFruit != fruits[i-1]) {
                    secondFruit = currFruit;
                    currFruitCount++;
                }
                if (result < i-tail+1) {
                    result = i-tail+1;
                }
                continue;
            }
            if (count[currFruit] == 0 && currFruitCount == 2) {
                if (result < i-tail) {
                    result = i-tail;
                }
                while (count[firstFruit] > 0 && count[secondFruit] > 0) {
                    count[fruits[tail++]]--;
                }
                firstFruit = fruits[tail];
                secondFruit = currFruit;
                count[secondFruit]++;
                continue;
            }
            count[currFruit]++;
            if (result < i-tail+1) {
                result = i-tail+1;
            }
        }
        return result;
    }
}
