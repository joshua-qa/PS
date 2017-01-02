import java.util.Scanner;

public class Main {
    static int[] numList = new int[1000001];
    public static void JO_print(int num) {
        numList[1] = 0;

        for(int a=1;a<=num;a++) {
            if(a+1 <= num && (numList[a+1] == 0 || numList[a+1] > numList[a] + 1)) {
                numList[a + 1] = numList[a] + 1;
            }
            if(a*2 <= num && (numList[a*2] == 0 || numList[a*2] > numList[a] + 1)) {
                numList[a * 2] = numList[a] + 1;
            }
            if(a*3 <= num && (numList[a*3] == 0 || numList[a*3] > numList[a] + 1)) {
                numList[a * 3] = numList[a] + 1;
            }
        }

        System.out.println(numList[num]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        JO_print(num);
    }
}