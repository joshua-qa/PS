package Joshua.PS.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by jgchoi.qa on 2017. 5. 29..
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numArray = new int[N+1];
        StringBuffer sb = new StringBuffer();
        int totalCount = ((1 + (N-1)) * (N-1) / 2);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            numArray[i] = Integer.parseInt(st.nextToken());
            totalCount -= numArray[i];
        }

        Arrays.sort(numArray, 1, N+1);

        boolean flag = true;
        for(int i = 1; i <= N; i++) {
            if(numArray[i] < 0 || numArray[i] > N-i) {
                flag = false;
                break;
            }

            for(int j = 0; j < N-i-numArray[i]; j++) {
                numArray[N-j]--;
            }
            Arrays.sort(numArray, i+1, N+1);
        }

        if(!flag || totalCount != 0) {
            sb.append("-1");
        } else {
            sb.append("1");
        }
        System.out.print(sb.toString());
    }
}