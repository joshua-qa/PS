package Joshua.PS;

import java.util.Scanner;

/**
 * Created by jgchoi.qa on 2017. 5. 9..
 */
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();

        System.out.println(m * n - 1);
    }
}
