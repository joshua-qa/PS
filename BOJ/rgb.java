package com.company;
import java.util.Scanner;

public class Main {
    static int[][] inputArr = new int[1001][3];
    static int[][] DP = new int[1001][3];
    public static int three_MIN(int a, int b, int c) {
        int MIN_value = 0;
        if(a<=b && a<=c) {
            MIN_value = a;
        } else if(b<=a && b<=c) {
            MIN_value = b;
        } else if(c<=a && c<=b) {
            MIN_value = c;
        }
        return MIN_value;
    }
    public static int MIN(int a, int b) {
        if(a >= b) {
            return b;
        } else {
            return a;
        }
    }
    public static void JO_print(int[][] input, int count) {
        DP[0][0] = input[0][0];
        DP[0][1] = input[0][1];
        DP[0][2] = input[0][2];

        for(int i=1;i<count;i++) {
            DP[i][0] = MIN(DP[i-1][1], DP[i-1][2]) + input[i][0];
            DP[i][1] = MIN(DP[i-1][0], DP[i-1][2]) + input[i][1];
            DP[i][2] = MIN(DP[i-1][0], DP[i-1][1]) + input[i][2];
        }
        System.out.println(three_MIN(DP[count-1][0], DP[count-1][1], DP[count-1][2]));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int house = sc.nextInt();


        for(int i=0;i<house;i++) {
            for(int j=0;j<3;j++) {
                inputArr[i][j] = sc.nextInt();
            }
        }

        JO_print(inputArr, house);
    }
}