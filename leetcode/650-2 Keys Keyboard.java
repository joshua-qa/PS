class Solution {
    public int minSteps(int n) {
        // bfs?
        // 짝수로 만들고 copy를 종료하면 이후에는 홀수로 돌릴 수가 없어서.. 소인수분해?

        int result = 0;
        for (int i = 2; i <= 1000; i++) {
            while (n % i == 0) {
                n /= i;
                result += i;
            }
            if (n == 1) {
                break;
            }
        }

        return result;
    }
}
