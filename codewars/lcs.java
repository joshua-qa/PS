public class Solution {
    public static String lcs(String x, String y) {
        StringBuilder sb = new StringBuilder();

        int[][] D = new int[x.length()+1][y.length()+1];

        for(int i = 1; i < D.length; i++) {
            for(int j = 1; j < D[0].length; j++) {
                if(x.charAt(i-1) == y.charAt(j-1)) {
                    D[i][j] = D[i-1][j-1] + 1;
                } else {
                    D[i][j] = Math.max(D[i-1][j], D[i][j-1]);
                }
            }
        }

        int currX = x.length();
        int currY = y.length();

        while(D[currX][currY] != 0) {
            if(D[currX-1][currY] == D[currX][currY]) {
                currX--;
            } else if(D[currX][currY-1] == D[currX][currY]) {
                currY--;
            } else {
                sb.append(x.charAt(currX-1));
                currX--;
                currY--;
            }
        }

        return sb.reverse().toString();
    }
}