package Joshua.PS;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by jgchoi.qa on 2017. 5. 7..
 */
public class Main {
    static Stack<Integer> stack = new Stack<>();
    final static int STICK_SIZE = 64;
    static int num;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        num = scan.nextInt();

        int result = cutStick(STICK_SIZE);

        System.out.println(result);
    }

    private static int cutStick(int piece) {
        if(STICK_SIZE == num) {
            return 1;
        }
        int halfPiece = piece / 2;

        stack.push(halfPiece);
        if(stackSum() < num) {
            return cutStick(halfPiece);
        } else if(stackSum() > num) {
            stack.pop();
            return cutStick(halfPiece);
        } else {
            return stack.size();
        }
    }

    private static int stackSum() {
        int temp = 0;
        for(int i = 0; i < stack.size(); i++) {
            temp += stack.elementAt(i);
        }
        return temp;
    }
}
