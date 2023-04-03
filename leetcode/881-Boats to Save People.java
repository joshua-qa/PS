// 18ms. 문제를 진짜 잘 읽어봐야한다. 두명만 태울 수 있다는거 놓쳐가지고 제대로 낚임..
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int length = people.length;
        if (length == 1) {
            return 1;
        }
        int result = 0;
        int start = 0;
        int end = length-1;
        Arrays.sort(people);
        int currLimit = limit;
        while (start <= end) {
            if (start == end) {
                result++;
                break;
            }
            if (people[end] <= currLimit) {
                currLimit -= people[end--];
            }
            if (people[start] <= currLimit) {
                currLimit -= people[start++];
            }
            currLimit = limit;
            result++;
        }

        return result;
    }
}
