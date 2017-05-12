package Joshua.PS.BOJ;

import java.util.*;

/**
 * Created by jgchoi.qa on 2017. 5. 12..
 */
public class Main {;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        char[][] input = new char[N][];
        int count = 0;
        char current;
        boolean flag;

        for(int i = 0; i < N; i++) {
            input[i] = scan.next().toCharArray();
        }


        for(int a = 0; a < N; a++) {
            flag = true;
            for (int i = 0; i < input[a].length - 2; i++) {
                current = input[a][i];
                for (int j = i + 1; j < input[a].length; j++) {
                    if(current != input[a][j-1] && current == input[a][j]) {
                        flag = false;
                        break;
                    }
                }
            }
            if(flag) {
                count++;
            }
        }

        System.out.println(count);
    }
}