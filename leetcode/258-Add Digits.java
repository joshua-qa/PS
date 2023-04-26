// 1ms. 이 문제를 푸는 개발자에게 무엇을 원하는건지 잘 모르겠다.
class Solution {
    public int addDigits(int num) {
        int result = 0;
        while (num > 0) {
            result += (num % 10);
            num /= 10;
        }
        return result < 10 ? result : addDigits(result);
    }
}
