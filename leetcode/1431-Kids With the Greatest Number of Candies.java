// 1ms. 쉬움
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        List<Boolean> result = new ArrayList<>();
        for (int candy : candies) {
            if (max < candy) {
                max = candy;
            }
        }
        for (int candy : candies) {
            if (candy + extraCandies >= max) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
    }
}
