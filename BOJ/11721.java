package Joshua.PS;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int lineCount;

        if(input.length() % 10 == 0) {
            lineCount = input.length() / 10;
        } else {
            lineCount = (input.length() / 10) + 1;
        }

        for (int i = 0; i < lineCount; i++) {
            if(i != lineCount-1) {
                System.out.println(input.substring(i*10, i*10+10));
            } else if(i == lineCount-1) {
                System.out.println(input.substring(i*10, input.length()));
            }
        }
    }
}