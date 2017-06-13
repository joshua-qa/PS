import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Joshua on 2017-06-13.
 */
public class Main {
    static int result = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.print(fac(N));
    }

    private static int fac(int n) {
        if(n == 0 || n == 1) {
            return result;
        } else {
            result *= n;
            return fac(n-1);
        }
    }
}
