import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int cal(int select, int[] num) {
        for (int j = 0; j < 9; j++) {
            for (int k = 0; k < 9; k++) {
                if (num[j] + num[k] != select || num[j] == num[k]) {
                    continue;
                } else if (num[j] + num[k] == select) {
                    num[j] = 0;
                    num[k] = 0;

                    for (int a = 0; a < 9; a++) {
                        if (num[a] != 0) {
                            System.out.println(num[a]);
                        }
                    }

                    return 0;
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num[] = new int[9];
        int total = 0;

        for (int i = 0; i < 9; i++) {
            num[i] = scan.nextInt();
            total += num[i];
        }

        int select = total - 100;

        Arrays.sort(num);
        cal(select, num);
    }
}