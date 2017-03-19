package Joshua.PS;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int[] caseNum = new int[num];
        int[][] studentArray = new int[num][1000];
        double[] averageArray = new double[num];
        int count;
        double[] goodStudentArray = new double[num];

        for (int i = 0; i < num; i++) {
            count = 0;
            caseNum[i] = scan.nextInt();
            for(int j = 0; j < caseNum[i]; j++) {
                studentArray[i][j] = scan.nextInt();
                averageArray[i] += studentArray[i][j];
            }
            averageArray[i] = averageArray[i] / caseNum[i];
            for(int k = 0; k < caseNum[i]; k++) {
                if (averageArray[i] < studentArray[i][k]) {
                    count++;
                }
            }
            goodStudentArray[i] = ((double)count / (double)caseNum[i]) * 100;
        }

        for(int a = 0; a < num; a++) {
            System.out.printf("%.3f", goodStudentArray[a]);
            System.out.print("%\n");
        }
    }
}