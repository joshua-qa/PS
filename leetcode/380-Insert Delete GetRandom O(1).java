// 66ms. 정해는 꼭 알아둬야 하는 풀이였다. 다음엔 그렇게 풀어봐야지
class RandomizedSet {
    private Set<Integer> set;
    private List<Integer> nums;
    private Random random;
    private int size;

    public RandomizedSet() {
        set = new HashSet<>();
        nums = new ArrayList<>();
        random = new Random();
        size = 0;
    }

    public boolean insert(int val) {
        nums.add(val);
        size++;
        return set.add(val);
    }

    public boolean remove(int val) {
        return set.remove(val);
    }

    public int getRandom() {
        while (true) {
            int randomIndex = random.nextInt(size);
            int randomNum = nums.get(randomIndex);
            if (set.contains(randomNum)) {
                return randomNum;
            }
        }
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
