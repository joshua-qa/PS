// 63ms. 다양한 풀이가 있기 때문에 Solution을 꼭 읽어보는 것이 좋다.
class BrowserHistory {
    private Deque<String> backStack, forwardStack;
    private String curr;
    public BrowserHistory(String homepage) {
        backStack = new ArrayDeque<>();
        forwardStack = new ArrayDeque<>();
        curr = homepage;
    }
    
    public void visit(String url) {
        forwardStack.clear();
        backStack.push(curr);
        curr = url;
    }
    
    public String back(int steps) {
        if (backStack.isEmpty()) {
            return curr;
        }
        while (!backStack.isEmpty() && steps > 0) {
            forwardStack.push(curr);
            curr = backStack.pop();
            steps--;
        }
        return curr;
    }
    
    public String forward(int steps) {
        if (forwardStack.isEmpty()) {
            return curr;
        }
        while (!forwardStack.isEmpty() && steps > 0) {
            backStack.push(curr);
            curr = forwardStack.pop();
            steps--;
        }
        return curr;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
 
