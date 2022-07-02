class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;

        int prev = Integer.MIN_VALUE;

        for (int i = 0; i < length; i++) {
            int num = nums[i];
            if (prev == num) {
                continue;
            }
            prev = num;
            int start = i+1;
            int end = length-1;
            int twoSum = -num;
            Map<Integer, Boolean> makeList = new HashMap<>();
            while (start < end) {
                int num2 = nums[start];
                int num3 = nums[end];
                if (num2 + num3 == twoSum) {
                    start++;
                    end--;
                    if (makeList.containsKey(num2) || makeList.containsKey(num3)) {
                        continue;
                    }
                    result.add(makeTriplet(num, num2, num3));
                    makeList.put(num2, true);
                    continue;
                }
                if (num2 + num3 > twoSum) {
                    end--;
                } else if (num2 + num3 < twoSum) {
                    start++;
                }
            }
        }

        return result;
    }

    private List<Integer> makeTriplet(int a, int b, int c) {
        List<Integer> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        return list;
    }
}
