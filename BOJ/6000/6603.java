import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if(n == 0) {
                break;
            }
            int[] lotto = new int[n];

            for(int i = 0; i < n; i++) {
                lotto[i] = Integer.parseInt(st.nextToken());
            }
            rec(-1, lotto, 1, "");
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }

    private static void rec(int i, int[] lotto, int l, String str) {
        if(l == 7) {
            sb.append(str + "\n");
            return;
        }

        for(int n = i+1; n < lotto.length - 6 + l; n++) {
            rec(n, lotto, l+1, str + lotto[n] + " ");
        }
    }
}