import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static long[] D;
    private final static int MOD = 10007;
    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        D = new long[n+1];

        D[1] = 1;
        D[2] = 3;

        for(int i = 3; i <= n; i++) {
            D[i] = 2*D[i-2] + D[i-1];
            D[i] %= MOD;
        }

        System.out.println(D[n]);
    }
}