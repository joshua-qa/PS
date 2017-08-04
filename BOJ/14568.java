import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private int n, th, ng, yh;
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int count = 0;

        for(int i = 1; i <= n-5; i++) {
            for(int j = i+2; j <= n - i - 2; j++) {
                for(int k = 2; k <= n - i - j; k += 2) {
                    if(i + j + k == n) {
                        count++;
                    }
                }
            }
        }

        System.out.print(count);
    }
}