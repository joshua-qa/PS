package Joshua.PS;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        String input = scan.nextLine();
        int result = 0;

        for (int i = 0; i < num; i++) {
            result += Integer.parseInt(input.substring(i, i+1));
        }
        System.out.println(result);
    }
}