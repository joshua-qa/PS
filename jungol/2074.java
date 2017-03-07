package Joshua.PS;

import java.util.Scanner;

public class Main {
    private static void MagicSquare(int input) {
        int[][] square = new int[input][input];
        int count = 1;
        int row = 0, col = input/2;

        while (count <= input*input) {
            square[row][col] = count;

            // input의 배수일 때 한칸 내리기
            if(count % input == 0) {
                row++;
            } else {
                row--;
                col--;
                if(row < 0) {
                    row = input-1;
                } else if(col < 0) {
                    col = input-1;
                }
            }
            count++;
        }

        for (int k = 0; k < input; k++) {
            for (int l = 0; l < input; l++) {
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

        MagicSquare(input);
    }
}
