// 0ms. 진짜 easy임
class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for (String word : word1) {
            sb.append(word);
        }

        for (String word : word2) {
            sb2.append(word);
        }
        return sb.toString().equals(sb2.toString());
    }
}
