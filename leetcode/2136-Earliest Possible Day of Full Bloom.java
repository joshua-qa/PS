// 71ms. 하드라고 하기엔 조금 빈약했을지도..
class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int length = plantTime.length;
        Pair<Integer, Integer>[] plantPairs = new Pair[length];
        for (int i = 0; i < length; i++) {
            plantPairs[i] = new Pair<>(plantTime[i], growTime[i]);
        }
        Arrays.sort(plantPairs, (o1, o2) -> o2.getValue() - o1.getValue());

        int start = 0;
        int result = 0;
        for (Pair<Integer, Integer> plantPair : plantPairs) {
            int bloomTime = getBloomTime(plantPair.getKey(), plantPair.getValue());
            if (start + bloomTime > result) {
                result = start + bloomTime;
            }
            start += plantPair.getKey();
        }
        return result - 1;
    }

    private int getBloomTime(int plantTime, int growTime) {
        return plantTime + growTime + 1;
    }
}
