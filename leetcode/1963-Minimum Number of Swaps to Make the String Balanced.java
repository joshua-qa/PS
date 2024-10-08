class Solution {
    public int minSwaps(String s) {
        char[] brackets = s.toCharArray();
        int size = brackets.length;
        int end = size - 1;
        int result = 0;

        for (int i = 0, open = 0, close = 0; i < end; i++) {
            if (brackets[i] == '[') {
                open++;
                continue;
            }
            // brackets[i] == ']'
            if (close + 1 > open) {
                while (brackets[end] != '[') {
                    end--;
                }
                result++;
                open++;
                brackets[i] = '[';
                brackets[end] = ']';
            } else {
                close++;
            }
        }
        return result;
    }
}
