package Joshua.PS.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by jgchoi.qa on 2017. 5. 28..
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] numArray = new int[3][4];
        int count;
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < 3; i++) {
            count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 4; j++) {
                numArray[i][j] = Integer.parseInt(st.nextToken());
                if(numArray[i][j] == 0) {
                    count++;
                }
            }
            if(count != 0) {
                sb.append((char)(count+64) + "\n");
            } else {
                sb.append("E\n");
            }
        }
        System.out.print(sb.toString());
    }
}