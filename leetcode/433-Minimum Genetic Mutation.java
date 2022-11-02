// 0ms. bfs로 풀어도 됐을듯
class Solution {
    private char[][] genes;
    private boolean[] visit;
    private int result, length;
    public int minMutation(String start, String end, String[] bank) {
        length = bank.length;
        result = Integer.MAX_VALUE;
        genes = new char[length][8];
        visit = new boolean[length];
        if (start.equals(end)) {
            return 0;
        }
        for (int i = 0; i < length; i++) {
            genes[i] = bank[i].toCharArray();
        }

        dfs(bank, start, end, -1, 0);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private void dfs(String[] bank, String curr, String end, int index, int currCount) {
        if (index != -1 && bank[index].equals(end)) {
            result = (result > currCount) ? currCount : result;
            return;
        }

        for (int i = 0; i < length; i++) {
            if (visit[i]) {
                continue;
            }
            if (isAvailable(curr.toCharArray(), genes[i])) {
                visit[i] = true;
                dfs(bank, bank[i], end, i, currCount+1);
                visit[i] = false;
            }
        }
    }

    private boolean isAvailable(char[] curr, char[] target) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            if (curr[i] != target[i]) {
                count++;
            }
        }
        return count == 1;
    }
}
