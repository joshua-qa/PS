import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static ArrayList<Integer> yakList;
    public static void cal_yaksu(int yaksu) {
        yakList = new ArrayList();

        // 제곱근 구하기
        int temp = (int)Math.sqrt(yaksu);

        // 전체 약수 구하기
        for(int i=1; i<=temp; i++) {
            if (yaksu % i == 0) {
                yakList.add(i);
                if(yaksu / i != i) {
                    yakList.add(yaksu/i);
                }
            }
        }

        int yaksize = yakList.size();
        Collections.sort(yakList);

        for(int j=0;j<yaksize;j++) {
            System.out.print(yakList.get(j) + " ");
        }

    }

    public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
        int yaksu = sc.nextInt();

        cal_yaksu(yaksu);
    }
}