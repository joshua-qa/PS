import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int bhp = Integer.parseInt(st.nextToken());
            int bmp = Integer.parseInt(st.nextToken());
            int bat = Integer.parseInt(st.nextToken());
            int bdf = Integer.parseInt(st.nextToken());
            bhp += Integer.parseInt(st.nextToken());
            if(bhp < 1) {
                bhp = 1;
            }
            bmp += Integer.parseInt(st.nextToken());
            if(bmp < 1) {
                bmp = 1;
            }
            bat += Integer.parseInt(st.nextToken());
            if(bat < 0) {
                bat = 0;
            }
            bdf += Integer.parseInt(st.nextToken());
            int ans = bhp + (bmp * 5) + (bat * 2) + (bdf * 2);

            sb.append(ans + "\n");
        }
        System.out.print(sb);
    }
}