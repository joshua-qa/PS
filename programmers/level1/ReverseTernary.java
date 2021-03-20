class Solution {
    public int solution(int n) {
        return ternaryToDecimal(decimalToTernary(n));
    }

    private String decimalToTernary(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int mod = n % 3;
            sb.append(mod);
            n /= 3;
        }
        return sb.toString();
    }

    private int ternaryToDecimal(String ternaryNumber) {
        int length = ternaryNumber.length();
        int result = 0;
        for (int i = length-1, j = 1; i >= 0; i--, j *= 3) {
            result += getNumber(ternaryNumber.charAt(i)) * j;
        }
        return result;
    }

    private int getNumber(char c) {
        return c - '0';
    }
}