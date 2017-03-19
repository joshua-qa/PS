package Joshua.PS;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        double[] scoreArray = new double[num];
        double maxScore = 0;
        double average = 0;

        for(int i = 0; i < num; i++) {
            scoreArray[i] = scan.nextDouble();
            if (maxScore < scoreArray[i]) {
                maxScore = scoreArray[i];
            }
        }

        for(int j = 0; j < num; j++) {
            scoreArray[j] = (scoreArray[j] / maxScore) * 100;
            average += scoreArray[j];
        }

        System.out.printf("%.2f", average / num);
    }
}