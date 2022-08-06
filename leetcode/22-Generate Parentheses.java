// 2ms. 재귀 연습용
class Solution {
    List<String> result;
    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        dfs("", n, n);
        return result;
    }

    private void dfs(String curr, int remainLeft, int remainRight) {
        if (remainLeft == 0 && remainRight == 0) {
            result.add(curr);
            return;
        }
        if (remainLeft > 0) {
            dfs(curr + "(", remainLeft-1, remainRight);
        }
        if (remainLeft < remainRight) {
            dfs(curr + ")", remainLeft, remainRight-1);
        }
    }
}
