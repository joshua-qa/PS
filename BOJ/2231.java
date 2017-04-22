package Joshua.PS.BOJ;

import java.util.*;

/**
 * Created by jgchoi.qa on 2017. 4. 22..
 */
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = scan.nextInt();

        System.out.println(solution(num));
    }

    private static int solution(int N) {
        int temp = 0;

        for(int i = 1; i < N; i++) {
            temp = i;
            char[] numArray = String.valueOf(i).toCharArray();
            for(int j = 0; j < numArray.length; j++) {
                temp += Character.getNumericValue(numArray[j]);
            }

            if(temp == N) {
                return i;
            }
        }

        return 0;
    }
}