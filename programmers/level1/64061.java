import java.util.*;
class Solution {
    private int length, result;
    private int[] top;
    public int solution(int[][] board, int[] moves) {
        length = board[0].length;
        top = new int[length];
        prepare(board);

        Stack<Integer> bag = new Stack<>();
        for (int move : moves) {
            int currentElement = catchElement(board, move-1);
            if (currentElement > 0) {
                addBag(bag, currentElement);
            }
        }
        return result;
    }

    private void prepare(int[][] board) {
        for (int i = 0; i < length; i++) {
            int j = 0;
            while (board[j][i] == 0) {
                j++;
            }
            top[i] = j;
        }
    }

    private int catchElement(int[][] board, int line) {
        if (board[length-1][line] == 0) {
            return 0;
        }
        int element = board[top[line]][line];
        board[top[line]][line] = 0;
        if (top[line] != length-1) {
            top[line]++;
        }
        return element;
    }

    private void addBag(Stack<Integer> bag, int currentElement) {
        if (bag.isEmpty()) {
            bag.push(currentElement);
            return;
        }

        int peek = bag.peek();
        if (peek == currentElement) {
            result += 2;
            bag.pop();
            return;
        }

        bag.push(currentElement);
    }
}