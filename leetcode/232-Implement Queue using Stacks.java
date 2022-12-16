// 0ms. 흔한 면접 질문이라 그냥 가볍게 풀어봤다..
class MyQueue {
    private Stack<Integer> leftStack, rightStack;
    public MyQueue() {
        leftStack = new Stack<>();
        rightStack = new Stack<>();
    }
    
    public void push(int x) {
        while (!leftStack.empty()) {
            rightStack.push(leftStack.pop());
        }
        rightStack.push(x);
    }
    
    public int pop() {
        while (!rightStack.empty()) {
            leftStack.push(rightStack.pop());
        }
        return leftStack.pop();
    }
    
    public int peek() {
        while (!rightStack.empty()) {
            leftStack.push(rightStack.pop());
        }
        return leftStack.peek();
    }
    
    public boolean empty() {
        return leftStack.empty() && rightStack.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
