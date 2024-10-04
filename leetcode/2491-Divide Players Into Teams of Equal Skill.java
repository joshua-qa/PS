class Solution {
    public long dividePlayers(int[] skill) {
        int totalSum = 0;
        long result = 0;
        int length = skill.length;
        int halfLength = length / 2;

        for (int val : skill) {
            totalSum += val;
        }

        if (totalSum % halfLength != 0) {
            return -1;
        }

        int div = totalSum / halfLength;

        Arrays.sort(skill);

        for (int i = 0; i < halfLength; i++) {
            if (skill[i] + skill[length-i-1] != div) {
                return -1;
            }
            result += (long) (skill[i] * skill[length-i-1]);
        }
        return result;
    }
}
