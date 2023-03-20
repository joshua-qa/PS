// 0ms. 어쩐지 이지 난이도인데 정답률이 32%더라...
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int result = 0;
        int index = 0;
        int curr = 0;
        int length = flowerbed.length;
        if (length == 1) {
            return flowerbed[0] == 0 || n == 0;
        }
        boolean startEmpty = flowerbed[0] == 0;
        boolean endEmpty = flowerbed[length-1] == 0;
        while (index < length) {
            if (flowerbed[index++] == 0) {
                curr++;
                continue;
            }

            if (startEmpty) {
                result += curr / 2;
                startEmpty = false;
            } else {
                result += (curr == 0) ? 0 : ((curr-1) / 2);
            }
            curr = 0;
        }
        if (curr == length) {
            result = (curr+1) / 2;
            return result >= n;
        }
        if (curr != 0) {
            result += curr / 2;
        }

        return result >= n;
    }
}
