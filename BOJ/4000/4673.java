package Joshua.PS;

public class Main {
    public static void main(String[] args) {
        int[] selfNum = new int[10001];
        int temp = 0;
        StringBuffer numString = new StringBuffer();

        for (int i = 1; i < selfNum.length; i++) {
            numString.append(i);
            temp = i;
            for (int j = 0; j < numString.length(); j++) {
                temp += Integer.parseInt(numString.substring(j, j+1));
            }
            numString.delete(0, numString.length());
            if (selfNum[i] == 0) {
                System.out.println(i);
            }
            if (temp >= selfNum.length) {
                continue;
            } else if (temp < selfNum.length && selfNum[temp] == 0) {
                selfNum[temp] = 1;
            }
        }
    }
}