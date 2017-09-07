import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    StringTokenizer st;
    int n, m, ans;
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        ans = (fac(n) / fac(n-m)) / fac(m);
        System.out.print(ans);
    }

    private int fac(int n) {
        if(n == 0) {
            return 1;
        } else {
            return n * fac(n-1);
        }
    }
}