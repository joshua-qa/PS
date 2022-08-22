// 2ms. 재귀랑 루프 없이 가능하냐는 내용이 써있어서 시도해봄
class Solution {
    public boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n-1)) == 0 && Integer.toBinaryString(n).length() % 2 == 1;
    }
}
