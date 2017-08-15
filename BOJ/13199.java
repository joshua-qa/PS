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
            int p = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            sb.append(get(p, m, f, c) + "\n");
        }

        System.out.print(sb);
    }

    private int get(int p, int m, int f, int c) {
        int dchicken = m/p;
        int schicken = m/p;

        int dcoupon = dchicken * c;
        int scoupon = schicken * c;

        dchicken += dcoupon / f;
        while(scoupon >= f) {
            schicken++;
            scoupon -= f;
            scoupon += c;
        }

        return schicken - dchicken;
    }
}