package Joshua.PS;

import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int[] cup = {1, 0, 0};
        int[][] move = new int[m][2];
        int temp;

        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            while(st.hasMoreTokens()) {
                move[i][0] = Integer.parseInt(st.nextToken());
                move[i][1] = Integer.parseInt(st.nextToken());
            }

            temp = cup[move[i][0]-1];
            cup[move[i][0]-1] = cup[move[i][1]-1];
            cup[move[i][1]-1] = temp;
        }

        if(cup[0] == 1) {
            temp = 1;
        } else if(cup[1] == 1) {
            temp = 2;
        } else if(cup[2] == 1) {
            temp = 3;
        } else {
            temp = -1;
        }
        System.out.println(temp);
    }
}