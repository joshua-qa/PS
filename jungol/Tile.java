import java.util.Scanner;

public class Tile {
    public static int gcd_cal(int a, int b) {
        if (b == 0) return a;
        else return (gcd_cal (b, a % b));
    }

    public static long cal_Tile(long w, long h) {
        if(w == h) {
            return 1;
        }
        long result;
        long toilet = w * h;
        int square = 0;

        if(w < h) {
            int temp = gcd_cal((int)w, (int)h);
            square = temp * temp;
        } else if(w > h) {
            int temp = gcd_cal((int)h, (int)w);
            square = temp * temp;
        }

        result = (long)(toilet / square);

        return result;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        long width = sc.nextInt();
        long height = sc.nextInt();

        System.out.println(cal_Tile(width, height));
    }
}
