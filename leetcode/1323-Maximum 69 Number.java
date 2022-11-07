// 0ms. 이렇게 쉬울 수가 없다. 진짜 그 정도임
class Solution {
    public int maximum69Number (int num) {
        char[] numChars = String.valueOf(num).toCharArray();
        for (int i = 0; i < numChars.length; i++) {
            if (numChars[i] == '6') {
                numChars[i] = '9';
                return Integer.parseInt(new String(numChars));
            }
        }
        return num;
    }
}
