// 12ms. n이 1인 케이스를 생각 안하고 냈다가 한번 틀렸는데 그거 수정하니 바로 맞았다. 정답률이 너무 낮아서 겁먹을뻔했는데 사람들이 많이 풀어본 문제라서 낮은건가...
// 공식 솔루션은 atan2 를 써서 푸는 코드를 보여주는데 이것도 사용법을 찾아봐야겠다.
class Solution {
    public int maxPoints(int[][] points) {
        int result = 2;
        int length = points.length;
        if (length == 1) {
            return 1;
        }

        for (int i = 0; i < length - 2; i++) {
            for (int j = i+1; j < length - 1; j++) {
                int curr = 2;
                for (int k = j+1; k < length; k++) {
                    int ccwResult = ccw(points[i][0], points[i][1], points[j][0], points[j][1], points[k][0], points[k][1]);
                    if (ccwResult == 0) {
                        curr++;
                    }
                }
                if (result < curr) {
                    result = curr;
                }
            }
        }

        return result;
    }

    private int ccw(int x1, int y1, int x2, int y2, int x3, int y3) {
        return (x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1);
    }
}
