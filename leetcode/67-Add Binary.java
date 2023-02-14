// 5ms. 회식날이라 지하철 기다리면서 풀었다. 솔직히 자바 쓰면 BigInteger로 날먹 가능.
import java.math.BigInteger;
class Solution {
    public String addBinary(String a, String b) {
        BigInteger aa = new BigInteger(a, 2);
        BigInteger bb = new BigInteger(b, 2);
        BigInteger c = aa.add(bb);
       return c.toString(2);
    }
}
