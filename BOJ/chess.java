import java.util.Scanner;

public class Main {
    static String[] chess = new String[8];
    public static int cal_chess(String[] chess) {
        int count = 0;

        // 입력받은 배열 기준으로 짝수라인의 짝수번이 white, 홀수라인의 홀수번도 white
        for(int i=0;i<8;i++) {
            for(int j=0;j<8;j++) {
                if((i%2 == 0 && j%2 == 0) || (i%2 == 1 && j%2 == 1)) {
                    if(chess[i].substring(j,j+1).equals("F")) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<8;i++) {
            chess[i] = sc.nextLine();
        }

        System.out.println(cal_chess(chess));
    }
}