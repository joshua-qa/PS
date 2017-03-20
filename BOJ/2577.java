package Joshua.PS;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numA = scan.nextInt();
        int numB = scan.nextInt();
        int numC = scan.nextInt();

        String result = String.valueOf(numA * numB * numC);
        int[] numArray = new int[10];
        int temp = 0;

        for (int i = 0; i < result.length(); i++) {
            temp = Integer.parseInt(result.substring(i, i+1));
            numArray[temp]++;
        }

        for (int j = 0; j < numArray.length; j++) {
            System.out.println(numArray[j]);
        }
    }
}