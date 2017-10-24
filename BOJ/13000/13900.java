import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    int n;
    int[] nums;
    long ans;
    long[] sum;
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        nums = new int[n+1];
        sum = new long[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i-1] + nums[i];
        }

        for(int i = 1; i < n; i++) {
            ans += nums[i] * (sum[n] - sum[i]);
        }

        System.out.print(ans);
    }
}