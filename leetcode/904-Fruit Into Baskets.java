class Solution {
    public int totalFruit(int[] fruits) {
        if (fruits.length < 3) {
            return fruits.length;
        }
        int left = 0, right = 1, basket1Num = fruits[0], basket2Num = -1, basket1LastIndex = 0, basket2LastIndex = 0, size = fruits.length, result = 0;

        while (right < size && fruits[right] == fruits[left]) {
            right++;
        }

        if (right == size) {
            return size;
        }

        basket2Num = fruits[right];
        basket1LastIndex = right-1;
        basket2LastIndex = right;
        result = right - left + 1;

        while (right + 1 < size) {
            right++;
            if (fruits[right] == basket1Num) {
                basket1LastIndex = right;
            } else if (fruits[right] == basket2Num) {
                basket2LastIndex = right;
            } else {
                int prevNum = fruits[right-1];
                left = (prevNum == basket1Num) ? (basket2LastIndex + 1) : (basket1LastIndex + 1);
                basket1Num = prevNum;
                basket1LastIndex = right-1;
                basket2Num = fruits[right];
                basket2LastIndex = right;
            }

            if (right - left + 1 > result) {
                result = right - left + 1;
            }
        }

        return result;
    }
}
