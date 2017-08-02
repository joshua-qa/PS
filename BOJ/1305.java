import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[] p = br.readLine().toCharArray();

        int[] a = preprocessing(p);

        System.out.println(n-a[n-1]);

    }

    private int[] preprocessing(char[] p) {
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