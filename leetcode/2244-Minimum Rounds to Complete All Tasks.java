// 34ms. 솔직히 이지 난이도에 가까운듯. 이게 무슨 미디엄이야..
class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int task : tasks) {
            int count = counts.getOrDefault(task, 0);
            counts.put(task, count+1);
        }

        int result = 0;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            int value = entry.getValue();
            if (value == 1) {
                return -1;
            }
            result += value / 3;
            if (value % 3 != 0) {
                result++;
            }
        }
        return result;
    }
}
