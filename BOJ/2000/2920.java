package Joshua.PS;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] num = new int[8];

        for (int i = 0; i < num.length; i++) {
            num[i] = scan.nextInt();
        }
        String result = "";
        boolean flag = true;

        if(num[0] == 1) {
            for (int j = 1; j < num.length; j++) {
                if(num[j] != j+1) {
                    flag = false;
                    result = "mixed";
                    break;
                }
            }
            if(flag) {
                result = "ascending";
            }
        } else if(num[0] == 8) {
            for (int j = 1; j < num.length; j++) {
                if(num[j] != 8-j) {
                    flag = false;
                    result = "mixed";
                    break;
                }
            }
            if(flag) {
                result = "descending";
            }
        } else {
            result = "mixed";
        }

        System.out.println(result);
    }
}