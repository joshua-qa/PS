package Joshua.PS.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private long[][] D = new long[402][402];
    private final long MOD = 1000000000;
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        D[1][1] = 1;
        D[1][2] = 1;

        for(int i = 2; i <= n+m; i++) {
            D[i][1] = 1;
            D[i][i+1] = 1;
            for(int j = 2; j <= i; j++) {
                D[i][j] = D[i-1][j] + D[i-1][j-1];
                D[i][j] %= MOD;
            }
        }

        System.out.print((D[n+m-1][m]) % MOD);
    }
}