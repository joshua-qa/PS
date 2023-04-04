// 9ms. 이정도면 이지 난이도인듯
class Solution {
    public int partitionString(String s) {
        int result = 0;
        boolean[] exists = new boolean[26];
        for (char c : s.toCharArray()) {
            if (exists[c - 'a']) {
                result++;
                Arrays.fill(exists, false);
            }
            exists[c - 'a'] = true;
        }
        return result + 1;
    }
}
