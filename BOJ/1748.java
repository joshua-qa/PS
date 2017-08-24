import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    int n;
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int ans = 0;
        int count = 0;
        int curr = 9;
        int i = 1;

        while(count <= n) {
            if(count + curr <= n) {
                ans += curr * i;
                count += curr;
            } else {
                ans += (n - count) * i;
                break;
            }

            curr *= 10;
            i++;
        }

        System.out.print(ans);
    }
}