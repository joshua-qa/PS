/**
 * 140ms. 비트 마스크 없이 DFS 백트래킹 깔끔하게 하는 풀이는 보고 잘 배워놔야겠다. 그래도 이번 문제로 비트 마스크 복습할 수 있었고 자력으로 풀어서 좋았다!
 */ 
class Solution {
    int[] sticks;
    int[] dp;
    int width, length, max;
    public boolean makesquare(int[] matchsticks) {
        Arrays.sort(matchsticks);
        sticks = matchsticks;
        length = matchsticks.length;
        max = (1 << length) - 1;
        dp = new int[1 << length];
        width = 0;
        if (length < 4) {
            return false;
        }

        for (int stick : matchsticks) {
            width += stick;
        }
        if (width % 4 != 0) {
            return false;
        }
        width /= 4;

        if (matchsticks[length-1] > width) {
            return false;
        }
        dfs(0, 0, 0);
        return dp[max] == 1;
    }

    private boolean dfs(int visit, int step, int currSum) {
        if (visit == max) {
            dp[visit] = 1;
            return true;
        }
        if (dp[visit] != 0) {
            return dp[visit] == 1;
        }

        int nextStep = (step+1) * width;
        if (currSum >= nextStep) {
            if (currSum == nextStep) {
                step++;
            } else {
                dp[visit] = -1;
                return false;
            }
        }

        for (int i = 0; i < length; i++) {
            if ((visit & (1 << i)) == (1 << i)) {
                continue;
            }
            visit |= (1 << i);
            boolean res = dfs(visit, step, currSum + sticks[i]);
            dp[visit] = res ? 1 : -1;
            visit ^= (1 << i);
        }
        return dp[visit] == 1;
    }
}
