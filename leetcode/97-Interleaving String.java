/**
 * 2ms. 이건 아무리 생각해도 하드다... DP는 역시 많이 풀어봐야함
 */
class Solution {
    boolean[][] visit;
    char[] c1, c2, c3;
    int s1Length, s2Length, s3Length;
    boolean flag;
    public boolean isInterleave(String s1, String s2, String s3) {
        flag = false;
        s1Length = s1.length();
        s2Length = s2.length();
        s3Length = s3.length();
        visit = new boolean[s1Length+1][s2Length+1];
        if (s1Length + s2Length != s3Length) {
            return false;
        }
        c1 = s1.toCharArray();
        c2 = s2.toCharArray();
        c3 = s3.toCharArray();

        return dfs(0, 0, 0);
    }

    private boolean dfs(int s1Pos, int s2Pos, int s3Pos) {
        if (flag) {
            return true;
        }
        if (s3Pos == s3Length) {
            flag = true;
            return true;
        }

        if ((s1Pos != s1Length && c1[s1Pos] != c3[s3Pos]) && (s2Pos != s2Length && c2[s2Pos] != c3[s3Pos])) {
            return false;
        }

        boolean flag = false;
        boolean flag2 = false;
        if (s1Pos != s1Length && c1[s1Pos] == c3[s3Pos] && !visit[s1Pos+1][s2Pos]) {
            visit[s1Pos+1][s2Pos] = true;
            flag = dfs(s1Pos+1, s2Pos, s3Pos+1);
        }
        if (s2Pos != s2Length && c2[s2Pos] == c3[s3Pos] && !visit[s1Pos][s2Pos+1]) {
            visit[s1Pos][s2Pos+1] = true;
            flag2 = dfs(s1Pos, s2Pos+1, s3Pos+1);
        }
        return flag || flag2;
    }
}
