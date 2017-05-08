import java.util.Scanner;

/**
 * Created by jgchoi.qa on 2017. 5. 7..
 */
public class Main {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        int input2 = scan.nextInt();
        int input3 = scan.nextInt();
        System.out.println(solution(input, input2, input3));
    }

    private static int solution(int n, int a, int b) {
        int answer = 0;

        while(true) {
            a = cal(a);
            b = cal(b);
            answer++;

            if (a == b) {
                break;
            }
        }

        return answer;
    }

    private static int cal(int a) {
        if (a % 2 == 0) {
            return a / 2;
        } else {
            return (a+1) / 2;
        }
    }
}