// 26ms. 문제를 잘못 이해해서 한번 틀렸는데 제출하고나니 Your runtime beats 98.54% 나와서 기분 좋아졌다. Stack 클래스보다 ArrayDeque 쓰는게 훨씬 빠름.
class StockSpanner {
    private Deque<Pair<Integer, Integer>> stack;
    private int index;
    public StockSpanner() {
        stack = new ArrayDeque<>();
        index = 1;
    }

    public int next(int price) {
        int day;
        while (!stack.isEmpty() && stack.peek().getValue() <= price) {
            stack.pop();
        }
        if (stack.isEmpty()) {
            day = index;
        } else {
            day = index - stack.peek().getKey();
        }
        stack.push(new Pair<>(index++, price));
        return day;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
