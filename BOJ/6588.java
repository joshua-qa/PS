import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private boolean[] prime = new boolean[1000001];
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int i;
        boolean flag;
        setPrime();

        while(true) {
            i = Integer.parseInt(br.readLine());
            flag = false;
            if(i == 0) {
                break;
            }

            for(int j = 3; j < i-2; j += 2) {
                if(!prime[j] && !prime[i-j]) {
                    sb.append(i + " = " + j + " + " + (i-j) + "\n");
                    flag = true;
                    break;
                }
            }

            if(!flag) {
                sb.append("Goldbach's conjecture is wrong.");
            }
        }

        System.out.print(sb.toString());
    }

    private void setPrime() {
        prime[1] = true;
        for(int i = 2; i*i < prime.length; i++) {
            if(prime[i]) {
                continue;
            }
            for(int j = i*2; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
    }
}