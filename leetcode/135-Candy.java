/**
 * 하드라서 걱정했는데 깔끔하게 6ms.. 시간 복잡도는 조금 개선 가능해보임
 */
class Solution {
    public int candy(int[] ratings) {
        int length = ratings.length;;
        int[] result = new int[length];
        int curr = length-1;
        while (curr >= 0) {
            int end = curr;
            while (curr > 0 && ratings[curr] > ratings[curr-1]) {
                curr--;
            }
            int start = curr;
            for (int i = start, candy = 1; i <= end; i++) {
                result[i] = candy;
                if (i != length-1 && ratings[i] < ratings[i+1]) {
                    candy++;
                }
            }
            if (end != length-1 && ratings[end] > ratings[end+1] && result[end] <= result[end+1]) {
                result[end] = result[end+1] + 1;
            }
            curr--;
        }
        int sum = 0;
        for (int num : result) {
            sum += num;
        }
        return sum;
    }
}
