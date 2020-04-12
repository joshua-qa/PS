public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.top();
        System.out.println(minStack.getMin());
    }
}

// min값 구하기를 위한 순회를 getMin에서 하지 않는게 핵심인듯. 3ms
class MinStack {
    public static final int STACK_SIZE = 1000;
    private int size, min = Integer.MAX_VALUE;
    private int[] stack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new int[STACK_SIZE];
    }

    public void push(int x) {
        if (size < STACK_SIZE) {
            stack[size++] = x;
        }
        if (min > x) {
            min = x;
        }
    }

    public void pop() {
        int popValue = stack[--size];
        if (popValue == min) {
            min = Integer.MAX_VALUE;
            for (int i = 0; i < size; i++) {
                if (min > stack[i]) {
                    min = stack[i];
                }
            }
        }
    }

    public int top() {
        return stack[size-1];
    }

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */