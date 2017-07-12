import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    final int MOD = 1000000;
    final int PISANO = MOD/10 * 15;
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        fibo(n % PISANO);
    }

    private void fibo(long n) {
        long a = 1;
        long b = 0;
        long fibo = 0;

        for(int i = 1; i <= n; i++) {
            fibo = (a % MOD) + (b % MOD);
            a = b;
            b = fibo;
            fibo %= MOD;
        }

        System.out.println(fibo);
    }
}