public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        int[] example1 = {2,2,1};
        int[] example2 = {4,1,2,1,2};
        System.out.println(singleNumber(example1));
        System.out.println(singleNumber(example2));
    }

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
