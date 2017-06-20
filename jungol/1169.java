import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Joshua on 2017-06-20.
 */
public class Main {
    String s = "";
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        switch (M) {
            case 1:
                rec1(N, 0, "");
                break;
            case 2:
                rec2(N, 0, "");
                break;
            case 3:
                rec3(N, 0, "");
                break;
        }
    }

    private void rec3(int n, int k, String s) {
        
    }

    private void rec2(int n, int k, String s) {

    }

    private void rec1(int n, int k, String s) {
        if (n == 1) {
            System.out.println(s + k);
        } else if(k == 0) {
            for(int i = 1; i <= 6; i++) {
                rec1(n, i, s);
            }
        } else {
            s += k + " ";
            for(int i = 0; i < 6; i++) {
                rec1(n - 1, i + 1, s);
            }
        }
    }
}
