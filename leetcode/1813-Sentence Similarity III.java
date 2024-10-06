class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if (sentence1.equals(sentence2)) {
            return true;
        }

        String[] s1Array = sentence1.split(" ");
        String[] s2Array = sentence2.split(" ");
        int s1Length = s1Array.length;
        int s2Length = s2Array.length;

        int s1 = 0, s2 = 0;
        int e1 = s1Length-1, e2 = s2Length-1;
        int equalCount = 0;

        while (s1 <= e1 && s2 <= e2) {
            int currCount = 0;
            while (s1 <= e1 && s2 <= e2 && s1Array[s1].equals(s2Array[s2])) {
                equalCount++;
                currCount++;
                s1++;
                s2++;
            }

            while (s1 <= e1 && s2 <= e2 && s1Array[e1].equals(s2Array[e2])) {
                currCount++;
                equalCount++;
                e1--;
                e2--;
            }

            if (currCount == 0) {
                return false;
            }
        }

        return equalCount >= s1Length || equalCount >= s2Length;
    }
}
