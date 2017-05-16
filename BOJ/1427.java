package Joshua.PS.BOJ;

import java.util.*;

/**
 * Created by jgchoi.qa on 2017. 5. 16..
 */
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        char[] numArray = scan.next().toCharArray();

        Arrays.sort(numArray);

        for(int i = 0; i < numArray.length; i++) {
            sb.append(numArray[i]);
        }

        System.out.println(sb.reverse());
    }
}