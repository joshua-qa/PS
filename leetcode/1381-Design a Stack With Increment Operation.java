class CustomStack {
    private int[] stack;
    private int topIndex = -1;

    public CustomStack(int maxSize) {
        stack = new int[maxSize];
    }
    
    public void push(int x) {
        if (topIndex == stack.length - 1) {
            return;
        }
        stack[++topIndex] = x;
    }
    
    public int pop() {
        if (topIndex == -1) {
            return -1;
        }
        return stack[topIndex--];
    }
    
    public void increment(int k, int val) {
        int endIndex = Math.min(k-1, topIndex);
        for (int i = 0; i <= endIndex; i++) {
            stack[i] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
