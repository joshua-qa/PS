package Joshua.PS;

import java.util.Scanner;

public class Main {
    private static void triangleCal(int input) {
        char[][] triangle = new char[input][input];
        int count = 0;

        for(int i = input / 2; i >= 0; i--) {
            for(int j = i; j < input-i; j++) {
                if(count == 26) {
                    count = 0;
                }
                triangle[j][i] = (char)(65+count++);
            }
        }

        for(int k = 0; k < input; k++) {
            for(int l = 0; l < input; l++) {
                System.out.print(triangle[k][l]+" ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();

        if(input > 0 && input < 100) {
            triangleCal(input);
        } else {
            System.out.println("INPUT ERROR");
        }
    }
}
