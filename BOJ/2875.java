import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int k = Integer.parseInt(str[2]);

        while(k-- > 0) {
            if(m * 2 > n) {
                m--;
            } else {
                n--;
            }
        }

        System.out.print((m * 2 > n) ? n / 2 : m);
    }
}