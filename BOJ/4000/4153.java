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

        while(true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a == 0 && b == 0 && c ==0) {
                break;
            } else {
                int ap = a*a;
                int bp = b*b;
                int cp = c*c;
                if(ap + bp == cp || ap + cp == bp || bp + cp == ap) {
                    sb.append("right\n");
                } else {
                    sb.append("wrong\n");
                }
            }
        }
        System.out.print(sb);
    }
}