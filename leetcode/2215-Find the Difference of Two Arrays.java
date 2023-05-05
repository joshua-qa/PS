// 11ms. 별 생각 없이 풀다가 한번 틀렸다. 짧게 짜는 연습이 필요
class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> distinct1 = new HashSet<>();
        Set<Integer> distinct2 = new HashSet<>();
        for (int num : nums1) {
            distinct1.add(num);
        }
        for (int num : nums2) {
            distinct2.add(num);
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> resultSubList1 = new ArrayList<>();
        for (int num : distinct1) {
            if (distinct2.contains(num)) {
                continue;
            }
            resultSubList1.add(num);
        }
        List<Integer> resultSubList2 = new ArrayList<>();
        for (int num : distinct2) {
            if (distinct1.contains(num)) {
                continue;
            }
            resultSubList2.add(num);
        }
        result.add(resultSubList1);
        result.add(resultSubList2);
        return result;
    }
}
