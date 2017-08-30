import java.util.*;
class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0;
        int[][] D = new int[board.length][board[0].length];

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 0) {
                    continue;
                } else if(i-1 < 0 || j-1 < 0) {
                    D[i][j] = 1;
                    answer = Math.max(1, answer);
                    continue;
                }

                if(D[i-1][j-1] == D[i-1][j] && D[i-1][j-1] == D[i][j-1]) {
                    D[i][j] = D[i-1][j-1] + 1;
                } else {
                    D[i][j] = Math.min(Math.min(D[i-1][j-1], D[i][j-1]), D[i-1][j]) + 1;
                }
                answer = Math.max(D[i][j], answer);
            }
        }

        return answer * answer;
    }
}