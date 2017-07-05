import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        int temp = 0;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            temp = Integer.valueOf(st.nextToken()) + Integer.valueOf(st.nextToken());
            System.out.println("Case #" + (i+1) + ": " + temp);
        }
    }
}