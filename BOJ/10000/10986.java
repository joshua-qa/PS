import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        long[] count = new long[m];
        
        st = new StringTokenizer(br.readLine());
        int prefix = Integer.parseInt(st.nextToken()) % m;
        count[prefix]++;
        for(int i = 1; i < n; i++) {
            prefix = (prefix + Integer.parseInt(st.nextToken())) % m;
            count[prefix]++;
        }
        
        long ans = count[0] * (count[0]+1);
        
        for(int i = 1; i < m; i++) {
            if(count[i] != 0) {
                ans += count[i] * (count[i] - 1);
            }
        }
    
        System.out.print(ans / 2);
    }
}
