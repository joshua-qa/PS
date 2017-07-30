import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] p = new int[n+1];
        if(n > 0) {
            p[1] = 1;
        }
        int prev = 0;
        int curr = 1;

        for(int i = 2; i <= n; i++) {
            p[i] = prev + curr;
            prev = curr;
            curr = p[i];
        }

        System.out.println(p[n]);
    }
}