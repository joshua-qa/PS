package Joshua.PS;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    private static void Postfix(int input, char[] array) {
        Stack<Integer> stack = new Stack();
        int temp = 0;
        int temp1 = 0;
        int result = 0;
        String operator = "";

        for(int i = 0; i < array.length; i++) {
            if(Character.isDigit(array[i])) {
                stack.push(Character.getNumericValue(array[i]));
            } else {
                temp = stack.pop();
                temp1 = stack.pop();

                operator = Character.toString(array[i]);

                if (operator.equals("+")) {
                    stack.push(temp1 + temp);
                } else if (operator.equals("-")) {
                    stack.push(temp1 - temp);
                } else if (operator.equals("*")) {
                    stack.push(temp1 * temp);
                } else if (operator.equals("/")) {
                    stack.push(temp1 / temp);
                }
            }
        }
        result = stack.pop();

        System.out.println(result);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        char[] post = new char[input];
        for(int i = 0; i < post.length; i++) {
            post[i] = scan.next().charAt(0);
        }

        Postfix(input, post);
    }
}
