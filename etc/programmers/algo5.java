class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int[][] D = new int[land.length + 1][4];

        for(int i = 1; i <= land.length; i++) {
            D[i][0] = Math.max(Math.max(D[i-1][1], D[i-1][2]), D[i-1][3]) + land[i-1][0];
            D[i][1] = Math.max(Math.max(D[i-1][0], D[i-1][2]), D[i-1][3]) + land[i-1][1];
            D[i][2] = Math.max(Math.max(D[i-1][0], D[i-1][1]), D[i-1][3]) + land[i-1][2];
            D[i][3] = Math.max(Math.max(D[i-1][1], D[i-1][2]), D[i-1][0]) + land[i-1][3];
        }

        for(int i = 0; i < 4; i++) {
            if(answer <= D[land.length][i]) {
                answer = D[land.length][i];
            }
        }
        return answer;
    }
}