import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] numArray = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            numArray[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0, end = 1, curr = numArray[start] + numArray[end], minSize = Integer.MAX_VALUE;

        while(end != n) {
            if(curr >= s) {
                minSize = Math.min(minSize, (end-start+1));
                curr -= numArray[start++];
                if (end + 1 == n) {
                    break;
                }
                if(end == start) {
                    curr += numArray[++end];
                }
            } else {
                if (end + 1 == n) {
                    break;
                } else {
                    curr += numArray[++end];
                }
            }
        }

        System.out.println(minSize == Integer.MAX_VALUE ? 0 : minSize);
    }
}