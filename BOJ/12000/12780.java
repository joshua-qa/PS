import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] H = br.readLine().toCharArray();
        char[] P = br.readLine().toCharArray();

        int[] pi = pre(P);

        int n = H.length;
        int m = P.length;
        int j = 0;
        int ans = 0;
        for(int i = 0; i < n; i++) {
            while(j > 0 && H[i] != P[j]) {
                j = pi[j - 1];
            }
            if(H[i] == P[j]) {
                if(j == m - 1) {
                    ans++;
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }
        System.out.print(ans);
    }

    private int[] pre(char[] p) {
        int[] pi = new int[p.length];

        int j = 0;
        for(int i = 1; i < pi.length; i++) {
            while(j > 0 && p[i] != p[j]) {
                j = pi[j-1];
            }
            if(p[i] == p[j]) {
                pi[i] = j+1;
                j += 1;
            } else {
                pi[i] = 0;
            }
        }

        return pi;
    }
}