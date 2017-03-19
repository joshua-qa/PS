package Joshua.PS;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int temp = 1;
        String input2 = input.trim();

        if(input2.equals("")) {
            temp = 0;
        }
        for(int i = 0; i < input2.length(); i++) {
            if(input2.substring(i, i+1).equals(" ")) {
                temp++;
            }
        }

        System.out.println(temp);
    }
}