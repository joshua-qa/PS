import java.util.Scanner;

public class Main {
    static int inputnum[] = new int[101];
    static int strike[] = new int[101];
    static int ball[] = new int[101];
    static int count = 0;

    public static void baseball(int n, int[] inputnum, int[] strike, int[] ball) {


        int input[][] = new int[n][3];
        for (int i = 0; i<n; i++) {
            input[i][0] = inputnum[i] / 100;
            input[i][1] = (inputnum[i] % 100) / 10;
            input[i][2] = inputnum[i] % 10;
        }

            for (int h = 1; h <= 9; h++) {
                for (int j = 1; j <= 9; j++) {
                    if (h == j) continue;

                    for (int k = 1; k <= 9; k++) {
                        boolean possible = true;

                        if (h == k) continue;
                        if (j == k) continue;
                        for (int i = 0; i < n; i++) {
                            int s = 0, b = 0;
                            if (h == input[i][0]) {
                                s++;
                            } else if (h == input[i][1] || h == input[i][2]) {
                                b++;
                            }

                            if (j == input[i][1]) {
                                s++;
                            } else if (j == input[i][0] || j == input[i][2]) {
                                b++;
                            }

                            if (k == input[i][2]) {
                                s++;
                            } else if (k == input[i][0] || k == input[i][1]) {
                                b++;
                            }

                            if (s != strike[i] || b != ball[i]) {
                                possible = false;
                            }
                        }

                        if (possible) {
                            count++;
                        }
                    }
                }
            }
    }

    public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=0; i<n; i++) {
            inputnum[i] = sc.nextInt();
            strike[i] = sc.nextInt();
            ball[i] = sc.nextInt();
        }

        baseball(n, inputnum, strike, ball);

        System.out.println(count);

    }
}
