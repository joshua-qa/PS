// 75ms. 헷갈리지 않고 짜서 만족
class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] result = new int[spells.length];
        int i = 0;
        for (int spell : spells) {
            int div = (int) (Math.ceil((double) success / (double) spell));
            int ub = upperBound(potions, div);
            if (ub == -1) {
                result[i] = 0;
            } else {
                result[i] = potions.length - ub;
            }
            i++;
        }
        return result;
    }

    private int upperBound(int[] potions, int target) {
        int start = 0;
        int end = potions.length-1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (potions[mid] >= target) {
                end = mid;
            } else {
                start = mid+1;
            }
        }
        return potions[start] >= target ? start : -1;
    }
}
