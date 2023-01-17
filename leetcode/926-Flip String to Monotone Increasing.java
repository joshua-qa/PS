// 13ms. 솔루션 코드가 엄청 간단해서 좀 놀랬다. 릿코드 처음 접했을 때만 해도 이런거 잘 못풀었는데.. 자력으로 풀어서 뿌듯
class Solution {
    public int minFlipsMonoIncr(String s) {
        int totalCount = s.length(), oneCount = 0, prevFlipCount = 0;
        int result = Integer.MAX_VALUE;
        char[] cs = s.toCharArray();
        for (char c : cs) {
            if (c == '1') {
                oneCount++;
            }
        }

        for (int i = 0; i < totalCount; i++) {
            if (oneCount == 0) {
                result = result > prevFlipCount ? prevFlipCount : result;
            }
            int curr = totalCount - i - oneCount + prevFlipCount;
            if (result > curr) {
                result = curr;
            }
            if (cs[i] == '1') {
                oneCount--;
                prevFlipCount++;
            }
        }
        return result;
    }
}
