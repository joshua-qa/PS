package Joshua.PS;

import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int[][] user = new int[m][2];

        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            user[i][0] = Integer.parseInt(st.nextToken());
            user[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < m; i++) {
            int high = 1;

            for(int j = 0; j < m; j++) {
                if(user[i][0] < user[j][0] && user[i][1] < user[j][1]) {
                    high++;
                }
            }

            System.out.print(high + " ");
        }
    }
}