// 0ms. 재밌는 문제다. 정석으로 풀었을 때 기준..
class Solution {
    public int strStr(String haystack, String needle) {
        int needleLength = needle.length();
        int haystackLength = haystack.length();
        if (needleLength > haystackLength) {
            return -1;
        }
        char[] h = haystack.toCharArray();
        char[] n = needle.toCharArray();
        char firstChar = n[0];

        for (int i = 0; i <= haystackLength - needleLength; ) {
            if (h[i] != n[0]) {
                i++;
                continue;
            }

            boolean flag = true;
            int firstIndex = i;
            int firstIndexOccurrence = i;
            for (int j = 0; j < needleLength; j++) {
                if (h[i] == firstChar && j != 0 && firstIndexOccurrence == i-j) {
                    firstIndexOccurrence = i;
                }
                if (h[i++] != n[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i - needleLength;
            }
            if (firstIndexOccurrence != firstIndex) {
                i = firstIndexOccurrence;
            }
        }
        return -1;
    }
}
