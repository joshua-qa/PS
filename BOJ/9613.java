import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] numArray = new int[n];
            for (int j = 0; j < n; j++) {
                numArray[j] = Integer.parseInt(st.nextToken());
            }
            sb.append(getTotal(numArray, n) + "\n");
        }
        System.out.print(sb.toString());
    }

    private static int getTotal(int[] numArray, int n) {
        int result = 0;
        for(int i = 0; i < numArray.length-1; i++) {
            for(int j = i+1; j < numArray.length; j++) {
                result += gcd(numArray[i], numArray[j]);
            }
        }

        return result;
    }

    public static int gcd(int p, int q)
    {
        if (q == 0) return p;
        return gcd(q, p%q);
    }
}