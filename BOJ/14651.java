import java.io.*;

public class Main {
    private final int MOD = 1000000009;
    private long[] D = new long[33334];
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        D[2] = 2;
        for(int i = 3; i <= n; i++) {
            D[i] = (D[i-1] * 3);
            D[i] %= MOD;
        }

        System.out.print(D[n] % MOD);
    }
}