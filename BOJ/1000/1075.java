import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int n = Integer.parseInt(br.readLine());
        int f = Integer.parseInt(br.readLine());

        if(n < 100) {
            n = 0;
        } else {
            n /= 100;
            n *= 100;
        }

        for(int i = 0; i <= 99; i++) {
            if((n + i) % f == 0) {
                sb.append(i);
                break;
            }
        }

        if(sb.length() == 1) {
            sb.insert(0, "0");
        }

        System.out.print(sb.toString());
    }
}