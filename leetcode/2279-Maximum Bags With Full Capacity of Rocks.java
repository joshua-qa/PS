// 14ms. 전처리 후 정렬한 뒤 그리디하게 접근하면 된다.
class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int length = capacity.length;
        for (int i = 0; i < length; i++) {
            capacity[i] -= rocks[i];
        }

        Arrays.sort(capacity);
        int result = 0;
        for (int i = 0; i < length; i++) {
            if (capacity[i] == 0) {
                result++;
                continue;
            }

            if (capacity[i] <= additionalRocks) {
                additionalRocks -= capacity[i];
                result++;
            } else {
                break;
            }
        }
        return result;
    }
}
