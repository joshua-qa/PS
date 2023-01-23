// 2ms. 신뢰 관계도를 가지고 카운팅을 한 뒤 조건에 만족하는 사람이 몇개인지 세어보면 된다.
class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trustCount = new int[n+1];
        int[] targetCount = new int[n+1];

        for (int[] edge : trust) {
            trustCount[edge[0]]++;
            targetCount[edge[1]]++;
        }

        int result = -1;
        for (int i = 1; i <= n; i++) {
            if (trustCount[i] == 0 && targetCount[i] == n-1) {
                if (result != -1) {
                    return -1;
                }
                result = i;
            }
        }
        return result;
    }
}
