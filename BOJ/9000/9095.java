import java.util.Scanner;

public class Main {
    static int[] inputArr = new int[100000];
    public static int recursive(int temp) {
        int[] result = new int[11];

        if(temp == 0 || temp == 1) {
            return 1;
        } else if(temp == 2) {
            return 2;
        } else if(result[temp] != 0) {
            return result[temp];
        } else {
            result[temp] = recursive(temp-3) + recursive(temp-2) + recursive(temp-1);
        }

        return result[temp];
    }
    public static void JO_print(int[] input, int count) {
        for(int i=0;i<count;i++) {
            System.out.println(recursive(input[i]));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();


        for(int i=0;i<num;i++) {
            inputArr[i] = sc.nextInt();
        }

        JO_print(inputArr, num);
    }
}