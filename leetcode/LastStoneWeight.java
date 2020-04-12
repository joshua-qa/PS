import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        int[] example = {2,7,4,1,8,1};
        int[] example2 = {3,7,2};
        System.out.println(lastStoneWeight(example));
        System.out.println(lastStoneWeight(example2));
    }

    // 깔끔하게 0ms
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1) {
            return stones[0];
        }
        int length = stones.length;
        int[] newStones;
        Arrays.sort(stones);

        if (stones[length-1] == stones[length-2]) {
            if (length == 2) {
                return 0;
            }
            newStones = new int[length - 2];
            for (int i = 0; i < newStones.length; i++) {
                newStones[i] = stones[i];
            }
        } else {
            newStones = new int[length - 1];
            stones[length-2] = stones[length-1] - stones[length-2];
            for (int i = 0; i < newStones.length; i++) {
                newStones[i] = stones[i];
            }
        }
        return lastStoneWeight(newStones);
    }
}
