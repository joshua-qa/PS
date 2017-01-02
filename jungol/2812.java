import java.util.Scanner;

public class Main {
    public static void hab(long num) {
        String numtext = String.valueOf(num);
        int temp = 0, sum;

        for(int i=0;i<numtext.length();i++) {
            sum = Integer.parseInt(numtext.substring(i,i+1));
            temp += sum;
        }
        System.out.println(temp);

        int temp2 = temp;
        if(temp2 > 9) {
            while (temp2 > 9) {
                String numtext2 = String.valueOf(temp2);
                temp2 = 0;
                for(int j=0;j<numtext2.length();j++) {
                    temp2 += Integer.parseInt(numtext2.substring(j, j+1));
                }
                System.out.println(temp2);
                if(temp2 < 10) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long inputnum = sc.nextLong();

        hab(inputnum);
    }
}