package Joshua.PS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] bingo = new int[5][5];
    static int count, numCount;

    private static boolean checkBingo() {
        int glineCount, slineCount, dCount1 = 0, dCount2 = 0;
        count = 0;

        for(int i = 0; i < 5; i++) {
            glineCount = 0;
            slineCount = 0;

            if(bingo[i][i] == 0) {
                dCount1++;
            }
            if(bingo[i][4-i] == 0) {
                dCount2++;
            }
            for(int j = 0; j < 5; j++) {
                if(bingo[i][j] == 0) {
                    glineCount++;
                }
                if(bingo[j][i] == 0) {
                    slineCount++;
                }
            }
            if(glineCount == 5) {
                count++;
            }
            if(slineCount == 5) {
                count++;
            }
        }
        if(dCount1 == 5) {
            count++;
        }
        if(dCount2 == 5) {
            count++;
        }

        if(count >= 3) {
            return true;
        } else {
            return false;
        }
    }

    private static void marking(int n) {
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(bingo[i][j] == n) {
                    bingo[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        boolean flag = false;

        for(int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < 5; j++) {
                bingo[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < 5; j++) {
                marking(Integer.parseInt(st.nextToken()));
                numCount++;
                if(checkBingo()) {
                    flag = true;
                    break;
                }
            }
            if(flag) {
                break;
            }
        }

        System.out.print(numCount);
    }
}