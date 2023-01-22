// 11ms. N 제한이 워낙 작아서 백트래킹이 가능한 문제..
class Solution {
    private List<List<String>> result;
    private int length;
    private char[] cs;
    private String str;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        length = s.length();
        str = s;
        cs = s.toCharArray();
        dfs(0, new ArrayList<>());
        return result;
    }

    private void dfs(int currIndex, List<String> currSet) {
        if (currIndex == length) {
            result.add(currSet);
            return;
        }

        for (int i = currIndex; i < length; i++) {
            if (isPalindrome(currIndex, i)) {
                List<String> newSet = new ArrayList<>(currSet);
                newSet.add(str.substring(currIndex, i+1));
                dfs(i+1, newSet);
            }
        }
    }

    private boolean isPalindrome(int start, int end) {
        if (start == end) {
            return true;
        }

        int size = end - start + 1;
        if ((size & 1) == 1) {
            size = (size + 1) / 2;
        } else {
            size = size / 2;
        }
        for (int i = 0; i < size; i++) {
            if (cs[start+i] != cs[end-i]) {
                return false;
            }
        }
        return true;
    }
}
