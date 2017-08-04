import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            sb.append(judge(x1, y1, r1, x2, y2, r2) + "\n");
        }

        System.out.print(sb);
    }

    private int judge(int x1, int y1, int r1, int x2, int y2, int r2) {
        if(x1 == x2 && y1 == y2 && r1 == r2) {
            return -1;
        }

        int x = (int)Math.pow(x2-x1, 2);
        int y = (int)Math.pow(y2-y1, 2);
        int d = x+y;
        int plus = (int)Math.pow(r2+r1 , 2);
        int minus1 = (int)Math.pow(r2-r1 , 2);
        int minus2 = (int)Math.pow(r1-r2 , 2);

        if(plus == d || minus1 == d || minus2 == d) {
            return 1;
        } else if(minus1 < d && d < plus) {
            return 2;
        } else {
            return 0;
        }
    }
}