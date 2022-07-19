// 2ms. 쉽지만 연습해두면 좋은 문제..
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            result.add(new ArrayList<>());
            for (int j = 0; j < i; j++) {
                if (i-1 <= 1 || j == 0 || j == i-1) {
                    result.get(i-1).add(1);
                } else {
                    int curr = result.get(i-2).get(j-1) + result.get(i-2).get(j);
                    result.get(i-1).add(curr);
                }
            }
        }
        return result;
    }
}
