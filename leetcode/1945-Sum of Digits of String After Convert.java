class Solution {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            sb.append(String.valueOf(s.charAt(i) - 'a' + 1));
        }
        int result = getResult(sb.toString());
        k--;
        while (k > 0) {
            result = getResult(String.valueOf(result));
            k--;
        }
        return result;
    }

    private int getResult(String num) {
        char[] chars = num.toCharArray();

        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            result += chars[i] - '0';
        }
        return result;
    }
}
