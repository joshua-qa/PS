package Joshua.PS;

import java.util.Scanner;

public class Main {
    private static void Zigzag(int input) {
        int[][] square = new int[input+1][input+1];
        int count = 1;
        int row = 0, col = 2;
        int flagNum = 1;
        int move = 1;

        // 루프를 input * 2 - 1 만큼 돌도록
        for (int n = 1; n <= (input * 2) - 1; n++) {
            if (n % 2 == 1) {
                for(int i = 1; i <= move; i++) {
                    square[++row][--col] = count++;
                }
                if(flagNum == 1) {
                    row++;
                } else {
                    col++;
                }
            } else if (n % 2 == 0) {
                for(int j = 1; j <= move; j++) {
                    square[row--][col++] = count++;
                }
                if(flagNum == 1) {
                    col++;
                } else {
                    row++;
                }
            }

            if(flagNum == 0) {
                move--;
            } else {
                move++;
            }

            if(move == input) {
                flagNum = 0;
            }
        }

        for (int k = 1; k <= input; k++) {
            for (int l = 1; l <= input; l++) {
                if (square[k][l] == 0) {
                    System.out.print(" ");
                } else {
                    System.out.print(square[k][l] + " ");
                }
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();

        Zigzag(input);
    }
}
