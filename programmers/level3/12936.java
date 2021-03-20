import java.util.*;
class Solution {
    public int[] solution(int n, long k) {
        int[] result = new int[n];
        List<Integer> numList = new ArrayList<>();

        k--;
        int index = 0;
        long fac = fac(n);
        long mod = fac / n;
        long level = n-1;
        for (int i = 1; i <= n; i++) {
            numList.add(i);
        }
        while (numList.size() > 2) {
            long current = k / mod;
            k %= mod;
            mod /= level--;
            int permutation = numList.remove((int) current);
            result[index++] = permutation;
        }

        if (k == 0) {
            result[index++] = numList.remove(0);
            result[index] = numList.remove(0);
        } else {
            result[index++] = numList.remove(1);
            result[index] = numList.remove(0);
        }
        return result;
    }

    private long fac(int n) {
        long result = 1;
        long num = (long) n;
        while (num > 1) {
            result *= num--;
        }
        return result;
    }
}