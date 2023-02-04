// 3ms. 슬라이딩 윈도우 문제다. 면접에서 나올만한 난이도..
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] count = new int[26];
        int[] s2Count = new int[26];
        int s1Length = s1.length();
        int s2Length = s2.length();
        for (int i = 0; i < s1Length; i++) {
            count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        for (int i = 0, end = s1Length - 1; i <= s2Length - s1Length; i++, end++) {
            boolean flag = true;
            for (int j = 0; j < 26; j++) {
                if (count[j] != s2Count[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
            if (end < s2Length-1) {
                s2Count[s2.charAt(i) - 'a']--;
                s2Count[s2.charAt(end+1) - 'a']++;
            }
        }

        return false;
    }
}
