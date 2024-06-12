class Solution {
    public void sortColors(int[] nums) {
        // 정수형 변수 한개를 세칸으로 생각해서 count를 담는다
        // ex) 100100100
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            switch (nums[i]) {
                case 0:
                    count += 1000000;
                    continue;
                case 1:
                    count += 1000;
                    continue;
                case 2:
                    count += 1;
            }
        }

        int index = 0;
        while (count >= 1000000) {
            nums[index++] = 0;
            count -= 1000000;
        }
        while (count >= 1000) {
            nums[index++] = 1;
            count -= 1000;
        }
        while (count > 0) {
            nums[index++] = 2;
            count -= 1;
        }
    }
}
