/**
 * 4ms.. 좀 어렵게 접근한거 같기도 하고
 */
class Solution {
    int[][] dp;
    int length;
    public int minimumTotal(List<List<Integer>> triangle) {
        length = triangle.size();
        int size = (length + 1) * length / 2;
        dp = new int[size][2];
        for (int i = 0; i < size; i++) {
            dp[i][0] = Integer.MAX_VALUE;
            dp[i][1] = Integer.MAX_VALUE;
        }

        int result = visit(1, 0, triangle);
        return result + triangle.get(0).get(0);
    }

    private int visit(int lineNum, int currNum, List<List<Integer>> triangle) {
        int index = getIndex(lineNum, currNum);
        if (lineNum == length) {
            return 0;
        }

        if (dp[currNum][0] == Integer.MAX_VALUE) {
            int left = triangle.get(lineNum).get(index);
            dp[currNum][0] = left + visit(lineNum + 1, currNum + lineNum, triangle);
        }
        if (dp[currNum][1] == Integer.MAX_VALUE) {
            int right = triangle.get(lineNum).get(index+1);
            dp[currNum][1] = right + visit(lineNum + 1, currNum + lineNum + 1, triangle);
        }
        return dp[currNum][0] <= dp[currNum][1] ? dp[currNum][0] : dp[currNum][1];
    }

    private int getIndex(int lineNum, int currNum) {
        return currNum - ((lineNum - 1) * lineNum / 2);
    }
}