package com.company;
import java.util.Scanner;

public class Main {
    public static void JO_print(int num) {
        int count = 0;

        if (num == 1) {
            System.out.println("A");
            return;
        }
        int array_size = (num*2) - 1;

        char[][] pArr = new char[array_size][array_size];

        int i=-1, j=num;

        while(i != num-1 || j != num-1) {
            while(i < num-1) {
                if(pArr[num-1][num-1] != 0) {
                    for(int a=0;a<array_size;a++) {
                        for(int b=0;b<array_size;b++) {
                            if(pArr[a][b] == 0) {
                                System.out.print("  ");
                            } else {
                                System.out.print(pArr[a][b] + " ");
                            }
                        }
                        System.out.println("");
                    }
                    return;
                }
                pArr[++i][--j] = (char)(65 + (count % 26));
                count++;
            }

            while(j < num-1) {
                pArr[++i][++j] = (char)(65 + (count % 26));
                count++;
            }

            while(i > num-1) {
                pArr[--i][++j] = (char)(65 + (count % 26));
                count++;
            }

            while(j > num) {
                pArr[--i][--j] = (char)(65 + (count % 26));
                count++;
            }

            i--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        JO_print(num);
    }
}