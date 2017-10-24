package com.company;
import java.util.Scanner;

public class Main {
    static int[][] inputArr = new int[301][301];
    static int[][] sumArr = new int[10001][4];
    public static void JO_print(int[][] input, int[][] sum, int w, int h, int count) {
        for(int i=0;i<count;i++) {
            int result = 0;
            int sum_i = sum[i][0];
            int sum_j = sum[i][1];
            int sum_x = sum[i][2];
            int sum_y = sum[i][3];

            for(int j=sum_i;j<=sum_x;j++) {
                for(int k=sum_j;k<=sum_y;k++) {
                    result += input[j-1][k-1];
                }
            }
            System.out.println(result);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int array_h = sc.nextInt();
        int array_w = sc.nextInt();

        for(int i=0;i<array_h;i++) {
            for(int j=0;j<array_w;j++) {
                inputArr[i][j] = sc.nextInt();
            }
        }
        int sum_count = sc.nextInt();

        for(int k=0;k<sum_count;k++) {
            for(int l=0;l<4;l++) {
                sumArr[k][l] = sc.nextInt();
            }
        }

        JO_print(inputArr, sumArr, array_h, array_w, sum_count);
    }
}