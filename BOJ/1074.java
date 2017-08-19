import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    int n, r, c, count, ans;
    StringTokenizer st;
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int p = (int)Math.pow(2, n);
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        if(n != 0) {
            go(0, 0, p);

            System.out.print(ans);
        } else {
            System.out.print("");
        }
    }

    private void go(int x, int y, int size) {
        if(size == 1) {
            if(x == r && y == c) {
                ans = count;
            } else {
                count++;
            }
            return;
        }

        go(x, y, size/2);
        go(x, y+size/2, size/2);
        go(x+size/2, y, size/2);
        go(x+size/2, y+size/2, size/2);
    }
}