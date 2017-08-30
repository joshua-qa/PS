class Solution {
	public int solution(int sticker[]) {
        int answer = 0;
        if(sticker.length == 1) {
            return sticker[0];
        } else if(sticker.length == 2) {
            return Math.max(sticker[0], sticker[1]);
        }

        int[][] D = new int[sticker.length+1][2];
        int[][] D2 = new int[sticker.length+1][2];

        D[1][0] = sticker[0];
        D2[sticker.length][0] = sticker[sticker.length-1];
        D2[sticker.length-1][0] = sticker[sticker.length-2];
        D2[sticker.length-1][1] = sticker[sticker.length-1];
        answer = Math.max(Math.max(D[1][0], D2[sticker.length][0]), D2[sticker.length-1][0]);

        for(int i = 2; i <= sticker.length-1; i++) {
            D[i][0] = Math.max(D[i-2][1], D[i-1][1]) + sticker[i-1];
            D[i][1] = D[i-1][0];
            answer = Math.max(Math.max(D[i][0], D[i][1]), answer);
        }

        for(int i = sticker.length-2; i >= 2; i--) {
            D2[i][0] = Math.max(D2[i+2][1], D2[i+1][1]) + sticker[i-1];
            D2[i][1] = D2[i+1][0];
            answer = Math.max(Math.max(D2[i][0], D2[i][1]), answer);
        }

        return answer;
    }
}