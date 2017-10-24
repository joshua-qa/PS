import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    int n, m, packageValue, singleValue, ans, allP, allS;
    int minP = Integer.MAX_VALUE;
    int minS = Integer.MAX_VALUE;
    StringTokenizer st;
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            packageValue = Integer.parseInt(st.nextToken());
            singleValue = Integer.parseInt(st.nextToken());
            if(minP > packageValue) {
                minP = packageValue;
            }
            if(minS > singleValue) {
                minS = singleValue;
            }
        }

        ans = (n / 6) * minP + (n % 6) * minS;
        allP = n % 6 == 0 ? n / 6 * minP : (n / 6 + 1) * minP;
        allS = n * minS;

        System.out.print(Math.min(Math.min(allP, allS), ans));
    }
}