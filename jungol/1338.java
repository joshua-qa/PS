package Joshua.PS;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        int count = 0;

        char[][] triangle = new char[input][input];

        for(int i = 0; i < input; i++) {
            for(int j = i; j < input; j++) {
                triangle[j][input-j+i-1] = (char)(65+count++);
            }
        }

        for(int k = 0; k < input; k++) {
            for(int l = 0; l < input; l++) {
                System.out.print(triangle[k][l]+" ");
            }
            System.out.println("");
        }
    }
}
