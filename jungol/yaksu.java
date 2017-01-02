import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static ArrayList<Integer> yakList;
    public static void gongyaksu(int gcd, int lcm) {
        int yaksu = lcm / gcd;
        int yaksu_temp = yaksu;
        yakList = new ArrayList();

        // 소인수분해
//        int i = 2;
//        int count=0;
//        while(i < yaksu) {
//            if(yaksu_temp % i == 0) {
//                yakarray[count] = i;
//                yaksu_temp = yaksu_temp / i;
//                count++;
//            } else if(yaksu_temp / i == 1 && yaksu_temp % i == 0) {
//                break;
//            } else {
//                i++;
//            }
//        }

        // 전체 약수 구하기
        for(int i=1; i<=yaksu; i++) {
            if (yaksu % i == 0) {
                yakList.add(i);
            }
        }

        int yaksize = yakList.size();
        if (yaksize == 1) {

            System.out.println(gcd + " " + lcm);

        }
        // 서로소인 경우 출력?
        if(yaksize % 2 == 1) {
            for(int i=1;i<=(yaksize/2);i++) {
                int a=yakList.get( ((yaksize)/2) - i);
                int b=yakList.get( ((yaksize)/2) + i);
                if(gcd_cal(a,b) == 1 && lcm_cal(a,b) == yaksu) {
                    System.out.println(a*gcd + " " + b*gcd);
                    break;
                }
            }
        } else if(yaksize % 2 == 0) {
            for(int i=1;i<=yaksize/2;i++) {
                int a=yakList.get( ((yaksize)/2) - i);
                int b=yakList.get( ((yaksize)/2-1) + i);
                if(gcd_cal(a,b) == 1 && lcm_cal(a,b) == yaksu) {
                    System.out.println(a*gcd + " " + b*gcd);
                    break;
                }
            }
        }

    }

    public static int gcd_cal(int a, int b) {
        if (b == 0) return a;
        else return (gcd_cal (b, a % b));
    }

    public static int lcm_cal(int a, int b) {
        int temp = gcd_cal(a, b);
        return (a*b)/temp;
    }

    public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
        int gcd = sc.nextInt();
        int lcm = sc.nextInt();

        gongyaksu(gcd, lcm);
    }
}