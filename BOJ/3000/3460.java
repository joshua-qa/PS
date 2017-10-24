import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    int n, m;
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            m = Integer.parseInt(br.readLine());
            String s = Integer.toBinaryString(m);
            char[] c = s.toCharArray();
            for(int j = c.length-1; j >= 0; j--) {
                if(c[j] == '1') {
                    sb.append((c.length-1-j) + " ");
                }
            }
        }

        System.out.print(sb);
    }
}