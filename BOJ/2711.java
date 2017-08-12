import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    public void run() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int pos = Integer.parseInt(st.nextToken()) - 1;
            char[] ca = st.nextToken().toCharArray();
            for(int j = 0; j < ca.length; j++) {
                if(j != pos) {
                    sb.append(ca[j]);
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
