package Joshua.PS;

import java.util.Scanner;

/**
 * Created by jgchoi.qa on 2017. 5. 9..
 */
public class Main {
    final static int CAR_QUANTITY = 5;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int[] group = new int[CAR_QUANTITY];
        int count = 0;
        int dayNum = num % 10;

        for(int i = 0; i < CAR_QUANTITY; i++) {
            group[i] = scan.nextInt();
        }

        for(int j = 0; j < CAR_QUANTITY; j++) {
            if(group[j] == dayNum) {
                count++;
            }
        }

        System.out.println(count);
    }
}
