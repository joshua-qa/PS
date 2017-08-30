class Solution {
    public boolean solution(int[] arr) {
        boolean answer = true;
        boolean[] nums = new boolean[100001];
        for(int i : arr) {
            if(nums[i] || i > arr.length) {
                answer = false;
            } else {
                nums[i] = true;
            }
        }
        return answer;
    }
}