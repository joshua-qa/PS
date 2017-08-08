import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            long p = Integer.parseInt(st.nextToken());
            long q = Integer.parseInt(st.nextToken());
            long g = gcd(p, q);
            sb.append((p * q) / g + "\n");
        }
        System.out.print(sb);
    }

    private long gcd(long p, long q) {
        if(q == 0) {
            return p;
        }
        return gcd(q, p%q);
    }
}