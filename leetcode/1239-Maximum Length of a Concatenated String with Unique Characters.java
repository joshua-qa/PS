// 51ms. 최적은 아닌데 일단 여기서 스톱
class Solution {
    private int max, length;
    private int[][] count;
    public int maxLength(List<String> arr) {
        length = arr.size();
        count = new int[length][26];
        for (int i = 0; i < length; i++) {
            char[] cs = arr.get(i).toCharArray();
            for (char c : cs) {
                count[i][c - 'a']++;
            }
        }
        dfs(0, new boolean[length]);
        return max;
    }

    private void dfs(int currPos, boolean[] visit) {
        if (currPos > 0) {
            int[] counts = new int[26];
            boolean isAvailable = true;
            for (int i = 0; i < currPos; i++) {
                if (!visit[i]) {
                    continue;
                }
                for (int j = 0; j < 26; j++) {
                    counts[j] += count[i][j];
                    if (counts[j] > 1) {
                        isAvailable = false;
                        break;
                    }
                }
                if (!isAvailable) {
                    return;
                }
            }
            int currCount = 0;
            for (int i = 0; i < 26; i++) {
                if (counts[i] == 1) {
                    currCount++;
                }
            }
            if (max < currCount) {
                max = currCount;
            }
        }
        if (currPos == length) {
            return;
        }

        visit[currPos] = true;
        dfs(currPos+1, visit);
        visit[currPos] = false;
        dfs(currPos+1, visit);
    }
}
