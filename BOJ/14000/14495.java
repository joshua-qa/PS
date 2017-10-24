import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    long[] fibo = new long[117];
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        fibo[1] = 1;
        fibo[2] = 1;
        fibo[3] = 1;

        for(int i = 4; i <= n; i++) {
            fibo[i] = fibo[i-3] + fibo[i-1];
        }

        System.out.print(fibo[n]);
    }
}