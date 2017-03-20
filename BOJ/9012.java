package Joshua.PS;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    private static int parenthesisString(String input) {
        Stack<String> stack = new Stack();

        for(int i = 0; i < input.length(); i++) {
            if (input.substring(i, i+1).equals("(")) {
                stack.push(input.substring(i, i+1));
            } else if (input.substring(i, i+1).equals(")")) {
                if (stack.size() == 0) {
                    System.out.println("NO");
                    return -1;
                } else {
                    stack.pop();
                }
            }
        }

        if (stack.size() == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        String[] inputArray = new String[num];
        scan.nextLine();

        for (int i = 0; i < num; i++) {
            inputArray[i] = scan.nextLine();
        }

        for (int j = 0; j < num; j++) {
            parenthesisString(inputArray[j]);
        }
    }
}