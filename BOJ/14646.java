import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] ballList = new int[n*2];
        int[] menu = new int[n+1];

        for(int i = 0; i < n*2; i++) {
            ballList[i] = Integer.parseInt(st.nextToken());
        }

        int curr = 0;
        int max = 0;
        for(int i = 0; i < n*2; i++) {
            int m = ballList[i];
            if(menu[m] > 0) {
                menu[m] = 0;
                curr--;
            } else {
                menu[m]++;
                curr++;
                if(curr > max) {
                    max = curr;
                }
            }
        }

        System.out.print(max);
    }
}