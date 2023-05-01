// 0ms. 5월 첫날이라고 이지를 내줬나보다.
class Solution {
    public double average(int[] salary) {
        int min = salary[0];
        int max = salary[0];
        for (int i = 1; i < salary.length; i++) {
            if (min > salary[i]) {
                min = salary[i];
            }
            if (max < salary[i]) {
                max = salary[i];
            }
            salary[i] += salary[i-1];
        }
        int total = salary[salary.length-1] - (min + max);
        return (double) total / (double) (salary.length-2);
    }
}
