import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 2*n-1; j++) {
                if(i == n-1) {
                    sb.append("*");
                } else {
                    if (i + j == n - 1 || j - i == n - 1) {
                        sb.append("*");
                    } else {
                        if(n-1 + i > j) {
                            sb.append(" ");
                        }
                    }
                }
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }
}