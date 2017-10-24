import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    int ans, curr, exit, boarding;
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        for(int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            exit = Integer.parseInt(st.nextToken());
            boarding = Integer.parseInt(st.nextToken());

            curr -= exit;
            curr += boarding;
            ans = Math.max(curr, ans);
        }

        System.out.print(ans);
    }
}