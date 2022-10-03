// 6ms. 순간 접근 방식을 착각해서 하드로 느껴졌다. 실상은 그리디하게 접근해야하는 쉬운 문제.
class Solution {
    public int minCost(String colors, int[] neededTime) {
        int length = neededTime.length;
        char[] cs = colors.toCharArray();
        int i = 0;
        int result = 0;
        while (i < length-1) {
            if (cs[i] != cs[i+1]) {
                i++;
                continue;
            }
            int max = neededTime[i];
            int sum = neededTime[i];
            while (i < length-1 && cs[i] == cs[i+1]) {
                i++;
                if (neededTime[i] > max) {
                    max = neededTime[i];
                }
                sum += neededTime[i];
            }
            result += (sum - max);
            i++;
        }
        return result;
    }
}
