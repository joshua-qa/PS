import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    long[] fibo = new long[81];
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        fibo(n);

        long width = fibo[n] + fibo[n-1];
        long height = fibo[n];

        System.out.print((width * 2) + (height * 2));
    }

    private void fibo(int n) {
        fibo[1] = 1;
        for(int i = 2; i <= n; i++) {
            fibo[i] = fibo[i-2] + fibo[i-1];
        }
    }
}