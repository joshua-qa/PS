package Joshua.PS;

import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] bingo = new int[500][500];
    static int count, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] board = { {11, 13, 15, 16}, {12, 1, 4, 3 }, {10, 2, 7, 8}, {5, 14, 6, 9} };

        int[][] board2 = {{6,15,17,14,23},{5,12,16,13,25},{21,4,2,1,22},{10,20,3,18,8},{11,9,19,24,7}};

        int[] nums = {14,3,2,4,13,1,16,11,5,15};

        int[] nums2 = {15,7,2,25,9,16,12,18,5,4,10,13,20};

        System.out.println(solution(board, nums));
        System.out.println(solution(board2, nums2));
    }

    private static int checkBingo() {
        int glineCount, slineCount, dCount1 = 0, dCount2 = 0;
        count = 0;

        for(int i = 0; i < n; i++) {
            glineCount = 0;
            slineCount = 0;

            if(bingo[i][i] == 0) {
                dCount1++;
            }
            if(bingo[i][n-i-1] == 0) {
                dCount2++;
            }
            for(int j = 0; j < n; j++) {
                if(bingo[i][j] == 0) {
                    glineCount++;
                }
                if(bingo[j][i] == 0) {
                    slineCount++;
                }
            }
            if(glineCount == n) {
                count++;
            }
            if(slineCount == n) {
                count++;
            }
        }
        if(dCount1 == n) {
            count++;
        }
        if(dCount2 == n) {
            count++;
        }

        return count;
    }

    private static void marking(int input) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(bingo[i][j] == input) {
                    bingo[i][j] = 0;
                }
            }
        }
    }

    public static int solution(int[][] board, int[] nums) {
        int answer = 0;

        n = board.length;

        bingo = board.clone();

        for(int i = 0; i < nums.length; i++) {
            marking(nums[i]);
        }

        answer = checkBingo();

        return answer;
    }
}