class Solution {
    public String addStrings(String num1, String num2) {
        boolean carry = false;
        StringBuilder sb = new StringBuilder();
        int maxSize = Math.max(num1.length(), num2.length());
        while (num1.length() < maxSize) {
            num1 = "0" + num1;
        }
        while (num2.length() < maxSize) {
            num2 = "0" + num2;
        }
        for (int i = maxSize-1; i >= 0; i--) {
            int current = (num1.charAt(i) - '0') + (num2.charAt(i) - '0');
            if (carry) {
                current++;
            }
            carry = current >= 10;
            sb.append(current % 10);
        }
        if (carry) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}