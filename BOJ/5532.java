import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    int l, a, b, c, d;
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        l = Integer.parseInt(br.readLine());
        a = Integer.parseInt(br.readLine());
        b = Integer.parseInt(br.readLine());
        c = Integer.parseInt(br.readLine());
        d = Integer.parseInt(br.readLine());

        int m = (a % c == 0) ? a / c : a / c + 1;
        int k = (b % d == 0) ? b / d : b / d + 1;

        System.out.print(l - Math.max(m, k));
    }
}