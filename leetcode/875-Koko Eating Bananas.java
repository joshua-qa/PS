// 17ms. 이런 류의 문제는 처음이 어렵지 익숙해지면 쉽다.
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int length = piles.length;
        int maxValue = 0;
        for (int pile : piles) {
            if (pile > maxValue) {
                maxValue = pile;
            }
        }

        int start = 1;
        int end = maxValue;

        while (start < end) {
            int mid = (start + end) / 2;
            int currHours = 0;
            for (int pile : piles) {
                if (pile % mid == 0) {
                    currHours += (pile / mid);
                } else {
                    currHours += (pile / mid) + 1;
                }
            }
            if (currHours <= h) {
                end = mid;
            } else {
                start = mid+1;
            }
        }
        return start;
    }
}
