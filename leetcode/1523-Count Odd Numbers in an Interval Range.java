// 0ms. 월요일 문제는 이지가 자주 나오는듯
class Solution {
    public int countOdds(int low, int high) {
        if (low == high) {
            return (low & 1) == 1 ? 1 : 0;
        }

        int count = high - low + 1;
        if ((count & 1) == 0) {
            return count / 2;
        }
        if ((low & 1) == 0) {
            return count / 2;
        }
        return (count + 1) / 2;
    }
}
