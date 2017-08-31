import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    int n, m;
    boolean[] prime = new boolean[1001];
    StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        getPrime();

        for(int i = 0; i < n; i++) {
            m = Integer.parseInt(br.readLine());
            check(m);
        }

        System.out.print(sb);
    }

    private void check(int p) {
        for(int i = 2; i <= p; i++) {
            if(prime[i]) {
                continue;
            }
            for(int j = 2; j <= p-i; j++) {
                if(prime[j]) {
                    continue;
                }
                for(int k = 2; k <= p-i-j; k++) {
                    if(prime[k] || i+j+k != p) {
                        continue;
                    }

                    if(i+j+k == p && !prime[i] && !prime[j] && !prime[k]) {
                        sb.append(i + " " + j + " " + k + "\n");
                        return;
                    }
                }
            }
        }
    }

    private void getPrime() {
        prime[1] = true;
        for(int i = 2; i * i < prime.length; i++) {
            if(prime[i]) {
                continue;
            }
            for(int j = i*2; j < prime.length; j+=i) {
                prime[j] = true;
            }
        }
    }
}