import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    boolean[] prime = new boolean[10001];
    StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 2; i*i <= prime.length; i++) {
            for(int j = i*2; j < prime.length; j += i) {
                prime[j] = true;
            }
        }

        for(int i = 2; i < prime.length; i++) {
            if(prime[i]) {
                continue;
            }
            while(n % i == 0) {
                n /= i;
                sb.append(i + "\n");
            }
        }

        if(n != 1) {
            sb.append(n + "\n");
        }

        System.out.print(sb.toString());
    }
}