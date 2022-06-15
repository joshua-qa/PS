/**
 * 미디엄은 아니고 하드 같은 느낌인데.. 9ms로 99.95% 나와서 기쁘다
 */
class Solution {
    private final int MAX_LENGTH = 16;
    int max;
    List<List<Integer>> graph;
    String[] wordsCopy;
    boolean[] visit;
    public int longestStrChain(String[] words) {
        max = 0;
        graph = new ArrayList<>();
        wordsCopy = words;
        int length = words.length;
        visit = new boolean[length];
        for (int i = 0; i < 26; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < length; i++) {
            int wordLength = words[i].length();
            graph.get(wordLength-1).add(i);
        }

        // dfs
        for (int i = 0; i < MAX_LENGTH; i++) {
            if (MAX_LENGTH - i - 1 < max) {
                break;
            }
            for (int wordIndex : graph.get(i)) {
                if (visit[wordIndex]) {
                    continue;
                }
                dfs(i+1, wordIndex, 1);
            }
        }
        return max;
    }

    private void dfs(int length, int curr, int chainCount) {
        visit[curr] = true;
        max = chainCount > max ? chainCount : max;
        if (length == MAX_LENGTH) {
            return;
        }

        for (int index : graph.get(length)) {
            if (visit[index]) {
                continue;
            }
            if (!check(wordsCopy[curr], wordsCopy[index])) {
                continue;
            }
            dfs(length + 1, index, chainCount + 1);
        }
    }

    private boolean check(String curr, String target) {
        int wrongCount = 0;
        int firstLength = curr.length();
        int secondLength = target.length();
        int first = 0;
        int second = 0;
        while (first != firstLength && second != secondLength) {
            if (curr.charAt(first) == target.charAt(second)) {
                first++;
                second++;
                continue;
            }

            wrongCount++;
            if (wrongCount == 2) {
                return false;
            }
            second++;
        }
        return true;
    }
}