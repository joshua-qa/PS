// 1ms. 의외로 틀리기 쉬운 문제여서 연습해두는게 좋을 것 같다. 짧게 푸는 연습도 해야할듯.
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int length = intervals.length;
        if (length == 0) {
            int[][] result = new int[][]{{newInterval[0], newInterval[1]}};
            return result;
        }

        List<int[]> table = new ArrayList<>();
        int mergedStart = newInterval[0], mergedEnd = newInterval[1];
        for (int[] interval : intervals) {
            if (!isOverLapping(interval[0], interval[1], mergedStart, mergedEnd)) {
                table.add(interval);
                continue;
            }

            mergedStart = Math.min(interval[0], mergedStart);
            mergedEnd = Math.max(interval[1], mergedEnd);
        }

        table.add(new int[]{mergedStart, mergedEnd});
        table.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int[][] result = new int[table.size()][2];
        for (int i = 0; i < result.length; i++) {
            result[i] = table.get(i);
        }
        return result;
    }

    private boolean isOverLapping(int start, int end, int newStart, int newEnd) {
        return !((start < newStart && end < newStart) || (start > newEnd && end > newEnd));
    }
}
