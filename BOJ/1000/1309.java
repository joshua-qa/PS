import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[][] D = new int[100001][3];
    private final static int MOD = 9901;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        D[1][0] = 1;
        D[1][1] = 1;
        D[1][2] = 1;
        int total = 0;

        for(int i = 2; i <= n; i++) {
            D[i][0] = D[i - 1][0] + D[i - 1][1] + D[i - 1][2];
            D[i][1] = D[i - 1][0] + D[i - 1][2];
            D[i][2] = D[i - 1][0] + D[i - 1][1];
            D[i][0] %= MOD;
            D[i][1] %= MOD;
            D[i][2] %= MOD;
        }

        total = D[n][0] + D[n][1] + D[n][2];

        System.out.println(total%MOD);

    }
}