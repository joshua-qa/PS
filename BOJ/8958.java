package Joshua.PS;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        String[] ox = new String[num];
        scan.nextLine();

        for (int i = 0; i < num; i++) {
            ox[i] = scan.nextLine();
        }

        int temp;
        int result;
        for (int j = 0; j < num; j++) {
            result = 0;
            temp = 1;
            for (int k = 0; k < ox[j].length(); k++) {
                if(ox[j].substring(k, k+1).equals("O")) {
                    result += temp++;
                } else {
                    temp = 1;
                }
            }
            System.out.println(result);
        }
    }
}