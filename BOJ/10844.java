import java.util.*;

/**
 * Created by jgchoi.qa on 2017. 5. 6..
 */
public class Main {
    final static int MOD = 1000000000;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int ans = 0;
        long[][] DP = new long[101][10];

        for(int a = 1; a < 10; a++) {
            DP[1][a] = 1;
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 0; j < 10; j++) {
                if(j == 0) {
                    DP[i][j] += DP[i-1][j+1] % MOD;
                } else if(j == 9) {
                    DP[i][j] += DP[i-1][j-1] % MOD;
                } else {
                    DP[i][j] += ((DP[i-1][j-1] % MOD) + (DP[i-1][j+1] % MOD)) % MOD;
                }
            }
        }

        for(int k = 0; k < 10; k++) {
            ans += DP[N][k];
            ans %= MOD;
        }

        System.out.println(ans);
    }
}