package Joshua.PS;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long N = scan.nextInt();
        int a = 1;
        long current = N-1;

        for (int i = 1; i <= N/2; i++) {
            if (current > 6*i) {
                current -= (6 * i);
                a++;
            } else {
                a++;
                break;
            }
        }

        System.out.println(a);
    }
}