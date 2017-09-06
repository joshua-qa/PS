import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    int n, m, x1, x2, y1, y2, cx, cy, r, ans;
    double startX, startY, destX, destY, start, dest, rpow;
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            m = Integer.parseInt(br.readLine());
            for(int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                cx = Integer.parseInt(st.nextToken());
                cy = Integer.parseInt(st.nextToken());
                r = Integer.parseInt(st.nextToken());

                startX = Math.pow(cx-x1, 2);
                startY = Math.pow(cy-y1, 2);
                start = startX+startY;
                destX = Math.pow(cx-x2, 2);
                destY = Math.pow(cy-y2, 2);
                dest = destX+destY;
                rpow = Math.pow(r, 2);

                if(judge(1) && !judge(2)) {
                    ans++;
                } else if(!judge(1) && judge(2)) {
                    ans++;
                }
            }

            sb.append(ans + "\n");
            ans = 0;
        }

        System.out.print(sb);
    }

    private boolean judge(int n) {
        if(n == 1) {
            return start <= rpow;
        } else {
            return dest <= rpow;
        }
    }
}