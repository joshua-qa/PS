// 284ms. floorKey, ceilingKey 쓰는 요령을 좀 더 잘 파악했다.
class MedianFinder {
    private TreeMap<Integer, Integer> nums;
    private int leftSubsetCount, rightSubsetCount, medianCount, currentMedian;
    public MedianFinder() {
        nums = new TreeMap<>();
    }

    public void addNum(int num) {
        if (nums.isEmpty()) {
            nums.put(num, 1);
            medianCount++;
            currentMedian = num;
            return;
        }

        if (num == currentMedian) {
            nums.put(num, nums.get(num) + 1);
            medianCount++;
            return;
        }

        if (num < currentMedian) {
            int count = nums.getOrDefault(num, 0);
            nums.put(num, count + 1);
            leftSubsetCount++;

            if (leftSubsetCount == (medianCount + rightSubsetCount)) {
                // 1) 왼쪽 subset count가 median count + 오른쪽 subset count랑 같아진 경우
                int prevMedianCount = medianCount;
                currentMedian = nums.floorKey(currentMedian - 1);
                medianCount = nums.get(currentMedian);
                leftSubsetCount -= medianCount;
                rightSubsetCount += prevMedianCount;
            }
            // 2) 왼쪽 subset count가 아직은 median count + 오른쪽 subset count보다 작은 경우
            return;
        }

        // num > currentMedian
        if (num > currentMedian) {
            int count = nums.getOrDefault(num, 0);
            nums.put(num, count + 1);
            rightSubsetCount++;

            if (rightSubsetCount == (leftSubsetCount + medianCount)) {
                return;
            }

            // ooovooooo
            if (rightSubsetCount > (leftSubsetCount + medianCount)) {
                int prevMedianCount = medianCount;
                currentMedian = nums.ceilingKey(currentMedian + 1);
                medianCount = nums.get(currentMedian);
                leftSubsetCount += prevMedianCount;
                rightSubsetCount -= medianCount;
            }
        }
    }

    public double findMedian() {
        int totalSize = leftSubsetCount + rightSubsetCount + medianCount;
        if ((totalSize & 1) == 1) {
            // 홀수인 경우
            return currentMedian;
        }

        // 1) 왼쪽 subset count + median count가 오른쪽 subset count보다 사이즈가 큰 경우
        if (leftSubsetCount + medianCount > rightSubsetCount) {
            return currentMedian;
        }
        // 2) 왼쪽 subset count + median count가 오른쪽 subset count와 같은 경우
        int rightNum = nums.ceilingKey(currentMedian + 1);
        return ((double) currentMedian + (double) rightNum) / 2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
