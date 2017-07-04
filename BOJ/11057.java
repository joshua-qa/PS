import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static long[][] D;
    private final static int MOD = 10007;
    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        D = new long[n+1][10];
        long total = 0;
        for(int i = 0; i <= 9; i++) {
            D[1][i] = 1;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= 9; j++) {
                for(int k = j; k <= 9; k++) {
                    D[i][j] += D[i - 1][k];
                    D[i][j] %= MOD;
                }
            }
        }

        for(int i = 0; i <= 9; i++) {
            total += D[n][i] % MOD;
        }

        System.out.print(total % MOD);
    }
}