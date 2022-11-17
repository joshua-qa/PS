// 4ms. 우아하지는 않지만 쉽게 접근해서 풀었다
class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int aWidth = (ay2 - ay1);
        int aHeight = (ax2 - ax1);
        int bWidth = (by2 - by1);
        int bHeight = (bx2 - bx1);

        if (ax1 >= bx2 || ax2 <= bx1 || ay1 >= by2 || ay2 <= by1) {
            return (aWidth * aHeight) + (bWidth * bHeight);
        }

        int x = 0, y = 0;
        if (ay1 < by1 && ay2 < by2) {
            y = ay2 - by1;
        }
        if (ay1 > by1 && ay2 > by2) {
            y = by2 - ay1;
        }
        if (ay1 >= by1 && ay2 <= by2) {
            y = ay2 - ay1;
        }
        if (ay1 <= by1 && ay2 >= by2) {
            y = by2 - by1;
        }

        if (ax1 < bx1 && ax2 < bx2) {
            x = ax2 - bx1;
        }
        if (ax1 > bx1 && ax2 > bx2) {
            x = bx2 - ax1;
        }
        if (ax1 >= bx1 && ax2 <= bx2) {
            x = ax2 - ax1;
        }
        if (ax1 <= bx1 && ax2 >= bx2) {
            x = bx2 - bx1;
        }

        return (aWidth * aHeight) + (bWidth * bHeight) - (x * y);
    }
}
