// 10ms. 무슨 이지 난이도에 힌트가 3개씩 붙어있나 했네..
// N 제한이 너무 느슨해서 이지가 맞는거 같긴 한데 사람에 따라서는 미디엄으로 느낄 수도 있을듯
class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        TreeMap<Integer, Integer> set = new TreeMap<>();
        int prefixSum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            set.put(prefixSum, i+1);
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            Map.Entry<Integer, Integer> floor = set.floorEntry(queries[i]);
            if (floor == null) {
                answer[i] = 0;
                continue;
            }

            answer[i] = floor.getValue();
        }
        return answer;
    }
}
