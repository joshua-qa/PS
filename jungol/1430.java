import java.util.Scanner;

public class Main {
    private static void cal_num(int abc) {
        String abctext = String.valueOf(abc);
        int[] numlist = new int[10];

        for(int i=0;i<10;i++) {
            for(int j=0;j<abctext.length();j++) {
                int temp = Integer.parseInt(abctext.substring(j,j+1));

                if(temp == i) {
                    numlist[i]++;
                }
            }
            System.out.println(numlist[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int abc = a * b * c;

        cal_num(abc);
    }
}