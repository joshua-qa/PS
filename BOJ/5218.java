import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    int n, c;
    StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char[] a = st.nextToken().toCharArray();
            char[] b = st.nextToken().toCharArray();
            sb.append("Distances: ");
            for(int j = 0; j < a.length; j++) {
                if(b[j] > a[j]) {
                    c = b[j] - a[j];
                } else {
                    c = b[j] + 26 - a[j];
                }
                sb.append(c == 26 ? 0 : c).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}