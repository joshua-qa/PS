package Joshua.PS;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack();
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        char temp;
        int temp2;

        for(int i = 0; i < input; i++) {
            temp = scan.next().charAt(0);

            if(Character.toString(temp).equals("i")) {
                temp2 = scan.nextInt();
                stack.push(temp2);
            } else if(Character.toString(temp).equals("c")) {
                System.out.println(stack.size());
            } else if(Character.toString(temp).equals("o")) {
                if(stack.isEmpty()) {
                    System.out.println("empty");
                } else {
                    int poptemp = stack.pop();
                    System.out.println(poptemp);
                }
            }
        }
    }
}
