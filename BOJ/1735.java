import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    int as, ap, bs, bp, anss, ansp, g;
    StringTokenizer st;
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        as = Integer.parseInt(st.nextToken());
        ap = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        bs = Integer.parseInt(st.nextToken());
        bp = Integer.parseInt(st.nextToken());

        ansp = (ap * bp) / gcd(ap, bp);
        anss = as * (ansp / ap) + bs * (ansp / bp);
        g = gcd(ansp, anss);

        System.out.print((anss / g) + " " + (ansp / g));
    }

    private int gcd(int p, int q) {
        if (q == 0) {
            return p;
        }
        return gcd(q, p%q);
    }
}