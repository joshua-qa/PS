// 3ms. 쉽지만 문제를 잘못 읽어서 한번 틀렸다..
class Solution {
    public String makeGood(String s) {
        return dfs(s);
    }

    private String dfs(String curr) {
        if (curr.equals("")) {
            return curr;
        }

        boolean isDeleted = false;

        StringBuilder sb = new StringBuilder();
        char[] cs = curr.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (i != cs.length-1 && (cs[i] - 32 == cs[i+1] || cs[i] + 32 == cs[i+1])) {
                isDeleted = true;
                i++;
                continue;
            }
            sb.append(cs[i]);
        }

        if (!isDeleted) {
            return sb.toString();
        }
        return dfs(sb.toString());
    }
}
