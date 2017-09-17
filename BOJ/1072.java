import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    long x, y, z;
    public void run() {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()) {
            x = sc.nextLong();
            y = sc.nextLong();
            z = (y * 100) / x;
            if((int)z >= 99) {
                System.out.println("-1");
            } else {
                System.out.println(search(1, 1000000000L));
            }
        }
    }

    public long search(long start, long end) {
        long mid = 0;
        while(start < end) {
            mid = (start + end) / 2;

            long newX = x + mid;
            long newY = y + mid;
            long newZ = (newY * 100) / newX;

            if (z == newZ) {
                start = mid+1;
            } else {
                end = mid;
            }
        }

        return start;
    }
}