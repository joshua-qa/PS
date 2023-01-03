// 15ms. 비추가 훨씬 많은 문제여서 놀랬다. 근데 요새 데일리 문제 너무 이지 난이도만 나오는거 아닌가..
class Solution {
    public int minDeletionSize(String[] strs) {
        int count = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 0; j < strs.length-1; j++) {
                if (strs[j+1].charAt(i) - strs[j].charAt(i) < 0) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
