import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    int[] bridge = new int[101];
    final char LEFT = 'L';
    final char RIGHT = 'R';
    // g : 2, r : 1, b : 0
    final int MOON = 0;
    final int HONG = 1;
    final int AHN = 2;
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = 0, h = 0, a = 0;
        double p = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int pos = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            fillBridge(pos, c);
        }

        for(int i = 1; i <= 100; i++) {
            if(bridge[i] == MOON) {
                m++;
            } else if(bridge[i] == HONG) {
                h++;
            } else if(bridge[i] == AHN){
                a++;
            }
        }

        double mg = p * m / 100;
        double hg = p * h / 100;
        double ag = p * a / 100;
        System.out.printf("%.2f\n%.2f\n%.2f", mg, hg, ag);
    }

    private void fillBridge(int pos, char c) {
        if(LEFT == c) {
            for(int i = 1; i < pos; i++) {
                bridge[i] = changeColor(bridge[i]);
            }
        } else if(RIGHT == c){
            for(int i = 100; i > pos; i--) {
                bridge[i] = changeColor(bridge[i]);
            }
        }
    }

    private int changeColor(int n) {
        return n == 0 ? 1 : n == 1 ? 2 : 0;
    }
}