// 1ms. 생각한 시간보다 코드 작성한 시간이 더 길정도로 쉬웠다.
class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int w1 = 0;
        int w2 = 0;
        while (w1 < word1.length() || w2 < word2.length()) {
            if (w1 < word1.length()) {
                sb.append(word1.charAt(w1++));
            }
            if (w2 < word2.length()) {
                sb.append(word2.charAt(w2++));
            }
        }
        return sb.toString();
    }
}
