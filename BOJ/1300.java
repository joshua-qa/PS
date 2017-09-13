import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    int n, m, ans;
    long min;
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        min = Math.min(1000000000L, (long)n*(long)n);

        int mid = 0;

        int start = 1;
        int end = (int)min;

        while(start <= end) {
            mid = (start + end)/2;
            int curr = 0;
            for(int i = 1; i <= n; i++) {
                curr += Math.min(mid / i, n);
            }

            if(curr >= m) {
                end = mid-1;
                ans = mid;
            } else {
                start = mid+1;
            }
        }

        System.out.print(ans);
    }
}