public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        String example = "abc";
        int[][] shift = {{0, 1}, {1, 2}};
        System.out.println(stringShift(example, shift));
        String example2 = "abcdefg";
        int[][] shift2 = {{1, 1}, {1, 1}, {0, 2}, {1, 3}};
        System.out.println(stringShift(example2, shift2));
        String example3 = "wpdhhcj";
        int[][] shift3 = {{0, 7}, {1, 7}, {1, 0}, {1, 3}, {0, 3}, {0, 6}, {1, 2}};
        System.out.println(stringShift(example3, shift3));
    }

    public String stringShift(String s, int[][] shift) {
        int length = s.length();
        int shiftSize = 0;
        for (int[] command : shift) {
            if (command[0] == 0) {
                shiftSize -= command[1];
            } else {
                shiftSize += command[1];
            }
        }
        shiftSize %= length;
        if (shiftSize < 0) {
            shiftSize += length;
        }
        return s.substring(length - shiftSize, length) + s.substring(0, length - shiftSize);
    }
}
