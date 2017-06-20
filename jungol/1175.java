import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Joshua on 2017-06-20.
 */
public class Main {
    static int sum;
    String s = "";
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        sum = Integer.parseInt(st.nextToken());

        rec1(N, 0, 0, "");
    }

    private void rec1(int n, int curr, int k, String s) {
        if (n == 1 && curr + k == sum) {
            System.out.println(s + k);
        } else if (n == 1 && curr + k != sum) {
            return;
        } else if(k == 0) {
            for(int i = 1; i <= 6; i++) {
                rec1(n, curr, i, s);
            }
        } else {
            s += k + " ";
            for(int i = 0; i < 6; i++) {
                rec1(n - 1, curr+k, i + 1, s);
            }
        }
    }
}
