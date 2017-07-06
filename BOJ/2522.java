import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();

        for(int i = 1; i <= n; i++) {
            for(int j = n; j > 0; j--) {
                if(j-i-1 >= 0) {
                    sb.append(" ");
                } else {
                    sb.append("*");
                }
            }
            sb.append("\n");
        }

        for(int i = n-1; i >= 1; i--) {
            for(int j = n; j > 0; j--) {
                if(j-i-1 >= 0) {
                    sb.append(" ");
                } else {
                    sb.append("*");
                }
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }
}