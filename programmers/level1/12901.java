// 프로그래머스 레벨1 - 2016년
class Solution {
    public String solution(int a, int b) {
        int[] month = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] day = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};

        int result = b - 1;

        for (int i = 0; i < a-1; i++) {
            result += month[i];
        }

        result %= 7;

        return day[result];
    }
}