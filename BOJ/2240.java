package Joshua.PS.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private int[][][] jadu = new int[2][1001][32];
    private int[] P = new int[1001];
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int n = parseInt(str[0]);
        int w = parseInt(str[1]);

        for(int i = 1; i <= n; i++) {
            P[i] = parseInt(br.readLine());
        }

        int max = 0;

        if(P[1] == 1) {
            jadu[0][1][1] = 1;
            jadu[1][1][2] = 0;
        } else {
            jadu[0][1][1] = 0;
            jadu[1][1][2] = 1;
        }

        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= w+1; j++) {
                if(P[i] == 1) {
                    jadu[0][i][j] = Math.max(jadu[0][i-1][j], jadu[1][i-1][j-1]) + 1;
                    jadu[1][i][j] = Math.max(jadu[0][i-1][j-1], jadu[1][i-1][j]);
                } else {
                    jadu[0][i][j] = Math.max(jadu[0][i-1][j], jadu[1][i-1][j-1]);
                    jadu[1][i][j] = Math.max(jadu[0][i-1][j-1], jadu[1][i-1][j]) + 1;
                }
                max = Math.max(max, Math.max(jadu[0][i][j], jadu[1][i][j]));
            }
        }

        System.out.println(max);
    }

    private int parseInt(String str) {
        return Integer.parseInt(str);
    }
}