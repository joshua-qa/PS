package Joshua.PS;

import java.util.Scanner;

/**
 * Created by jgchoi.qa on 2017. 3. 17..
 */
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.next();

        // numArray[0] -> 2 (3second), numArray[n].time = n+3;
        String[] numArray = {"ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
        int result = 0;

        for (int i = 0; i < input.length(); i++) {
            for (int j = 0; j < numArray.length; j++) {
                if (numArray[j].contains(input.substring(i, i + 1))) {
                    result += j+3;
                }
            }
        }

        System.out.println(result);
    }
}