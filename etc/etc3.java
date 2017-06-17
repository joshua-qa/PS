package Joshua.PS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] board = {{1,2,0,0},{1,0,2,0},{1,0,0,0},{1,0,0,1}};

        int k = 2;
        int Ax = 1;
        int Ay = 1;
        int Bx = 2;
        int By = 2;

        System.out.println(solution(board, k, Ax, Ay, Bx, By));

    }

    public static int solution(int[][] board, int K, int Ax, int Ay, int Bx, int By) {
        int answer = 0;

        int N = board.length;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(board[i][j] == 1) {
                    bombCheck(board, i, j, K);
                }
            }
        }



        return answer;
    }

    private static void bombCheck(int[][] board, int x, int y, int k) {
        boolean up = true, down = true, left = true, right = true;
        int n = board.length;
        for(int i = 0; i <= k; i++) {
            if(y-i >= 0 && left) {
                if(board[x][y-i] == 2) {
                    left = false;
                } else if(board[x][y-i] == 1){
                    board[x][y-i] = 1;
                } else {
                    board[x][y-i] = 3;
                }
            }
            if(y+i < n && right) {
                if(board[x][y+i] == 2) {
                    right = false;
                } else if(board[x][y+i] == 1) {
                    board[x][y + i] = 1;
                } else {
                    board[x][y+i] = 3;
                }
            }
            if(x-i >= 0 && up) {
                if(board[x-i][y] == 2) {
                    up = false;
                } else if(board[x-i][y] == 1) {
                    board[x - i][y] = 1;
                } else {
                    board[x-i][y] = 3;
                }
            }
            if(x+i < n && down) {
                if(board[x+i][y] == 2) {
                    down = false;
                } else if(board[x+i][y] == 1) {
                    board[x + i][y] = 1;
                } else {
                    board[x+i][y] = 3;
                }
            }
        }
    }
}