class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // arr1에 대해 count array 먼저 만들고.. arr2 순회하면서 갯수만큼 result에 담고 arr1count에서 소거
        // arr1count의 잔여 항목들을 앞부터 조사해서 오름차순으로 result 뒤에 나열
        int[] result = new int[arr1.length];
        int[] count = new int[1001];

        for (int i = 0; i < arr1.length; i++) {
            count[arr1[i]]++;
        }

        int resultIndex = 0;
        for (int i = 0; i < arr2.length; i++) {
            while (count[arr2[i]]-- > 0) {
                result[resultIndex++] = arr2[i];
            }
        }

        for (int i = 0; i <= 1000; i++) {
            while (count[i]-- > 0) {
                result[resultIndex++] = i;
            }
        }
        return result;
    }
}
