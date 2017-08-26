import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Created by jgchoi.qa on 2017. 8. 24..
 */

public class Solution {

    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();
        char[] expressionArray = expression.toCharArray();
        for(char bracket : expressionArray) {
            if(bracket == '(' || bracket == '[' || bracket == '{') {
                stack.push(bracket);
            } else if(stack.size() > 0 && isMatched(stack.peek(), bracket)) {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.size() == 0;
    }

    public static boolean isMatched(char s, char e) {
        boolean caseOne = (s == '(') && (e == ')');
        boolean caseTwo = (s == '[') && (e == ']');
        boolean caseThree = (s == '{') && (e == '}');
        return caseOne || caseTwo || caseThree;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }
}