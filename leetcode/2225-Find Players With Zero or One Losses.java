// 162ms. 시간 좀 더 줄일 수 있는데 귀찮아서 여기까지
class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> winCount = new HashMap<>();
        Map<Integer, Integer> lossCount = new HashMap<>();
        for (int[] match : matches) {
            int prevWinCount = winCount.getOrDefault(match[0], 0);
            int prevLossCount = lossCount.getOrDefault(match[1], 0);
            winCount.put(match[0], prevWinCount+1);
            lossCount.put(match[1], prevLossCount+1);
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> notLostAnyMatches = new ArrayList<>();
        for (int key : winCount.keySet()) {
            if (!lossCount.containsKey(key)) {
                notLostAnyMatches.add(key);
            }
        }
        List<Integer> lostExactlyOneMatch = new ArrayList<>();
        for (int key : lossCount.keySet()) {
            if (lossCount.get(key) == 1) {
                lostExactlyOneMatch.add(key);
            }
        }
        Collections.sort(notLostAnyMatches);
        Collections.sort(lostExactlyOneMatch);
        result.add(notLostAnyMatches);
        result.add(lostExactlyOneMatch);
        return result;
    }
}
