// 4ms. k가 1인 경우와 1이 아닌 경우만 따지면 된다. 빠르게 한번에 풀어서 기쁘다
class Solution {
    public String orderlyQueue(String s, int k) {
        int length = s.length();
        if (k == 1) {
            String min = s;
            StringBuilder sb = new StringBuilder(s);
            for (int i = 0; i < length; i++) {
                char c = sb.charAt(0);
                sb.deleteCharAt(0);
                sb.append(c);
                String curr = sb.toString();
                if (curr.compareTo(min) < 0) {
                    min = curr;
                }
            }
            return min;
        }

        int[] count = new int[26];
        char[] cs = s.toCharArray();
        for (char c : cs) {
            count[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            while (count[i] > 0) {
                count[i]--;
                sb.append((char)(i + 'a'));
            }
        }
        return sb.toString();
    }
}
