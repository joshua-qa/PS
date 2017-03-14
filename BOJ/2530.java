package Joshua.PS.BOJ;

import java.util.Scanner;

/**
 * Created by jgchoi.qa on 2017. 3. 14..
 */
public class AIClock {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int H = scan.nextInt();
        int M = scan.nextInt();
        int D = scan.nextInt();
        int ovenTime = scan.nextInt();

        ovenTime = ovenTime % 86400;
        int ovenHour = ovenTime / 3600;
        int ovenMinute = (ovenTime % 3600) / 60;
        int ovenSecond = (ovenTime % 3600) % 60;

        H += ovenHour;
        M += ovenMinute;
        D += ovenSecond;

        if (D > 59) {
            M += D / 60;
            D = D % 60;
        }
        if (M > 59) {
            H += M / 60;
            M = M % 60;
        }
        if (H > 23) {
            H = H % 24;
        }
        System.out.println(H + " " + M + " " + D);
    }
}