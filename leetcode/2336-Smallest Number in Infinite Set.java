// 38ms. 하드코딩으로 풀었는데 다음에 다시 풀어봐야 할듯..
class SmallestInfiniteSet {
    private TreeSet<Integer> infiniteSet;
    public SmallestInfiniteSet() {
        infiniteSet = new TreeSet<>();
        for (int i = 1; i <= 1000; i++) {
            infiniteSet.add(i);
        }
    }
    
    public int popSmallest() {
        return infiniteSet.pollFirst();
    }
    
    public void addBack(int num) {
        if (infiniteSet.contains(num)) {
            return;
        }
        infiniteSet.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
