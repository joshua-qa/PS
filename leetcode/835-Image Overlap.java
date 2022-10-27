// 126ms. 공식 솔루션이 참신한게 있을 줄 알았더니 딱히 그렇지도 않았다... 물론 유저들 풀이는 좋은 것들이 있었음.
// 그림으로 그려보면서 푸는게 헷갈리지 않는 지름길임.
class Solution {
    private int[][] overlap;
    private int length, n;
    public int largestOverlap(int[][] img1, int[][] img2) {
        int result = 0;
        length = img1.length;
        overlap = new int[length][length];

        n = length-1;
        for (int i = -n; i <= n; i++) {
            for (int j = -n; j <= n; j++) {
                for (int k = 0; k < length; k++) {
                    for (int l = 0; l < length; l++) {
                        int currX = k+i;
                        int currY = l+j;
                        if (currX < 0 || currX > n || currY < 0 || currY > n) {
                            continue;
                        }
                        overlap[currX][currY] = img1[k][l];
                    }
                }
                int score = compare(img2);
                if (score > result) {
                    result = score;
                }
                reset();
            }
        }
        return result;
    }

    private void reset() {
        for (int i = 0; i < length; i++) {
            Arrays.fill(overlap[i], 0);
        }
    }

    private int compare(int[][] img2) {
        int curr = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (overlap[i][j] == img2[i][j] && overlap[i][j] == 1) {
                    curr++;
                }
            }
        }
        return curr;
    }
}
