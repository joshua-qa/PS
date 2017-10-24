import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private int[] woolim = new int[9];
    private int[] startlink = new int[9];
    private boolean flag;
    private int woolimScore, startlinkScore;
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < woolim.length; i++) {
            woolim[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < startlink.length; i++) {
            startlink[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < woolim.length; i++) {
            woolimScore += woolim[i];
            if(woolimScore > startlinkScore) {
                flag = true;
            }
            startlinkScore += startlink[i];
        }
        System.out.print(flag ? "Yes" : "No");
    }
}