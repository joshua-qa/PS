// 1305ms. 정해는 읽어보니 깔끔한데 쉽게 생각해내기 어려운 풀이인듯...
class Solution {
    public int concatenatedBinary(int n) {
        long mod = 1000000007L;
        long result = 0;
        long mul = 1;
        for (int i = n; i >= 0; i--) {
            long origin = i;
            while (origin > 0) {
                if ((origin & 1) == 1) {
                    result += mul;
                }
                origin >>= 1;
                mul <<= 1;
                mul %= mod;
            }
        }
        return (int) (result % mod);
    }
}
