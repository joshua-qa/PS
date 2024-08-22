class Solution {
    public int findComplement(int num) {
        char[] reverse = Integer.toBinaryString(num).toCharArray();
        int result = 0;
        for (int i = reverse.length - 1, j = 1; i >= 0; i--, j *= 2) {
            if (reverse[i] == '0') {
                result += j;
            }
        }
        return result;
    }
}
