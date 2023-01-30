// 0ms. 딱히 어려울게 없는 문제다... 시키는대로 하면 풀림
class Solution {
    public int tribonacci(int n) {
        int[] fibo = new int[38];
        fibo[1] = fibo[2] = 1;
        if (n < 3) {
            return fibo[n];
        }
        for (int i = 3; i <= n; i++) {
            fibo[i] = fibo[i-3] + fibo[i-2] + fibo[i-1];
        }
        return fibo[n];
    }
}
