import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static int[] coin = {500, 100, 50, 10, 5, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 1000 - Integer.parseInt(br.readLine());
        int count = 0;
        int i = 0;

        while(n > 0) {
            if(coin[i] <= n) {
                n -= coin[i];
                count++;
            } else {
                i++;
            }
        }
        System.out.print(count);
    }
}