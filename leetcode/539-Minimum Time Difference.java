class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> minutes = new ArrayList<>();
        for (String timePoint : timePoints) {
            minutes.add(Integer.parseInt(timePoint.substring(0,2)) * 60 + Integer.parseInt(timePoint.substring(3)));
        }

        Collections.sort(minutes);
        int size = minutes.size();

        int result = (1440 + minutes.get(0)) - minutes.get(size-1);

        for (int i = size-1; i > 0; i--) {
            int diff = minutes.get(i) - minutes.get(i-1);
            if (result > diff) {
                result = diff;
            }
        }
        return result;
    }
}
