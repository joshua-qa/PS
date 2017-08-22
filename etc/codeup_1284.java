import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    StringTokenizer st;
    boolean[] prime = new boolean[5000001];
    int n;
    StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        pre();

        for(int i = 2; i * i <= n; i++) {
            if(n % i == 0 && !prime[i] && !prime[n/i]) {
                sb.append(i + " " + (n/i));
                break;
            }
        }
        if(sb.length() == 0) {
            sb.append("wrong number");
        }
        System.out.print(sb);
    }

    private void pre() {
        for(int i = 2; i*i < prime.length; i++) {
            if(prime[i]) {
                continue;
            }
            for(int j = i*2; j < prime.length; j += i) {
                if(prime[j]) {
                    continue;
                }
                prime[j] = true;
            }
        }
    }
}