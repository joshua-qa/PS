class Solution {
    public boolean validPalindrome(String s) {
        int length = s.length();
        if (length == 0) {
            return false;
        }
        if (length <= 2) {
            return true;
        }
        return isPalindrome(s, true) || isPalindrome(s, false);
    }
    private boolean isPalindrome(String s, boolean isLeft) {
        int length = s.length();
        boolean isDeleted = false;
        int left = 0;
        int right = length - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                if (isDeleted) {
                    return false;
                }
                if (isLeft && s.charAt(left + 1) == s.charAt(right)) {
                    left++;
                    isDeleted = true;
                } else if (!isLeft && s.charAt(left) == s.charAt(right - 1)) {
                    right--;
                    isDeleted = true;
                } else {
                    return false;
                }
            }
            left++;
            right--;
        }
        return true;
    }
}