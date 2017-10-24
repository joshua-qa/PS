package Joshua.PS;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int count = 0;
        int temp = 0;
        int temp2 = 0;
        boolean flag;

        StringBuffer numString = new StringBuffer();

        for (int i = 1; i <= num; i++) {
            if(i < 100) {
                count++;
                continue;
            }
            numString.append(i);
            flag = true;

            for (int j = 0; j < numString.length()-2; j++) {
                temp = Integer.parseInt(numString.substring(j+1,j+2)) - Integer.parseInt(numString.substring(j,j+1));
                temp2 = Integer.parseInt(numString.substring(j+2,j+3)) - Integer.parseInt(numString.substring(j+1,j+2));
                if (temp != temp2) {
                    flag = false;
                }
            }
            if (flag) {
                count++;
            }

            numString.delete(0, numString.length());
        }

        System.out.println(count);
    }
}