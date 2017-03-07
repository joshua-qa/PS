package Joshua.PS;

import java.util.Scanner;

public class Main {
    private static void triangleCal(int input, int type) {
        int[][] triangle = new int[input][input];

        for(int i = 0; i < input; i++) {
            for(int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    triangle[i][j] = 1;
                } else {
                    triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j];
                }
            }
        }

        if (type == 1) {
            for (int k = 0; k < input; k++) {
                for (int l = 0; l < input; l++) {
                    if (triangle[k][l] == 0) {
                        System.out.print(" ");
                    } else {
                        System.out.print(triangle[k][l] + " ");
                    }
                }
                System.out.println("");
            }
        } else if (type == 2) {
            for (int k = input-1; k >= 0; k--) {
                for (int l = input-1; l >= 0; l--) {
                    if (triangle[k][l] == 0) {
                        System.out.print(" ");
                    } else {
                        System.out.print(triangle[k][l] + " ");
                    }
                }
                System.out.println("");
            }
        } else if (type == 3) {
            for (int k = input-1; k >= 0; k--) {
                for (int l = input-1; l >= 0; l--) {
                    if (triangle[l][k] == 0) {
                        System.out.print(" ");
                    } else {
                        System.out.print(triangle[l][k] + " ");
                    }
                }
                System.out.println("");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        int type = scan.nextInt();

        triangleCal(input, type);
    }
}
