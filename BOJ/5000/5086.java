import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int first, second;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            first = Integer.parseInt(st.nextToken());
            second = Integer.parseInt(st.nextToken());

            if(first == second && first == 0) {
                break;
            }

            if(first % second == 0 && first / second > 0) {
                sb.append("multiple\n");
            } else if(second % first == 0 && second / first > 0) {
                sb.append("factor\n");
            } else {
                sb.append("neither\n");
            }
        }

        System.out.print(sb.toString());
    }
}