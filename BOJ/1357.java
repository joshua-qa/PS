import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder(st.nextToken());
        StringBuilder sb2 = new StringBuilder(st.nextToken());

        int x = Integer.parseInt(sb.reverse().toString());
        int y = Integer.parseInt(sb2.reverse().toString());

        int rev = x+y;
        sb.delete(0, sb.length());
        sb.append(rev);

        sb.reverse();
        System.out.print(Integer.parseInt(sb.toString()));
    }
}