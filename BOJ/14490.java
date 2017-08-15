import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(":");
        int p = Integer.parseInt(s[0]);
        int q = Integer.parseInt(s[1]);
        int g = gcd(p, q);

        System.out.println((p/g) + ":" + (q/g));
    }

    public static int gcd(int p, int q) {
        if (q == 0) return p;
        return gcd(q, p % q);
    }
}