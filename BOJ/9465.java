package Joshua.PS.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.valueOf(br.readLine());
        StringTokenizer st;

        for(int i = 0; i < t; i++) {
            int n = Integer.valueOf(br.readLine());
            int[][] D = new int[2][n+1];
            for(int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k = 1; k <= n; k++) {
                    D[j][k] = Integer.valueOf(st.nextToken());
                }
            }

            System.out.println(solution(n, D));
        }
    }

    private static int solution(int n, int[][] sticker) {
        int DP[][] = new int[2][n+1];
        DP[0][1] = sticker[0][1];
        DP[1][1] = sticker[1][1];
        int twomax = 0;
        int result = Math.max(DP[0][1], DP[1][1]);

        for(int j = 2; j <= n; j++) {
            twomax = Math.max(DP[0][j-2], DP[1][j-2]);
            DP[0][j] = Math.max(twomax, DP[1][j-1]) + sticker[0][j];
            DP[1][j] = Math.max(twomax, DP[0][j-1]) + sticker[1][j];
            if(Math.max(DP[0][j], DP[1][j]) > result) {
                result = Math.max(DP[0][j], DP[1][j]);
            }
        }

        return result;
    }
}