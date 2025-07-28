class Solution {
    public int longestPalindrome(String s) {
        int[] lowerCount = new int[26];
        int[] upperCount = new int[26];
        for (char c : s.toCharArray()) {
            if (c - 'a' >= 0 && c - 'a' < 26) {
                lowerCount[c - 'a']++;
                continue;
            }
            if (c - 'A' >= 0 && c - 'A' < 26) {
                upperCount[c - 'A']++;
            }
        }
        boolean isOdd = false;
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (lowerCount[i] % 2 == 1) {
                isOdd = true;
                count += lowerCount[i] - 1;
            } else {
                count += lowerCount[i];
            }
            if (upperCount[i] % 2 == 1) {
                isOdd = true;
                count += upperCount[i] - 1;
            } else {
                count += upperCount[i];
            }
        }
        return isOdd ? count + 1 : count;
    }
}
