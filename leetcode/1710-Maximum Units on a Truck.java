class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        int result = 0;
        for (int i = 0; i < boxTypes.length && truckSize > 0; i++) {
            if (truckSize > boxTypes[i][0]) {
                truckSize -= boxTypes[i][0];
                result += (boxTypes[i][0] * boxTypes[i][1]);
                continue;
            } else {
                result += (truckSize * boxTypes[i][1]);
                break;
            }
        }
        return result;
    }
}
