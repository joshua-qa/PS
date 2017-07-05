import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        StringBuffer sb = new StringBuffer();

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= 2*n; j++) {
                if(j <= i || j >= 2*n-i+1) {
                    sb.append("*");
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }

        for(int i = n-1; i > 0; i--) {
            for(int j = 1; j <= 2*n; j++) {
                if(j <= i || j >= 2*n-i+1) {
                    sb.append("*");
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}