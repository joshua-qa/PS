import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private final int E_MAX = 15;
    private final int S_MAX = 28;
    private final int M_MAX = 19;
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int e = Integer.parseInt(str[0]);
        int s = Integer.parseInt(str[1]);
        int m = Integer.parseInt(str[2]);

        int result = 1;
        int a = 1, b = 1, c = 1;

        while(a != e || b != s || c != m) {
            a++;
            b++;
            c++;
            result++;

            if(a > E_MAX) {
                a = 1;
            }
            if(b > S_MAX) {
                b = 1;
            }
            if(c > M_MAX) {
                c = 1;
            }
        }

        System.out.print(result);
    }
}