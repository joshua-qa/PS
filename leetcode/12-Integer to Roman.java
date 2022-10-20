// 7ms. 원리만 알면 쉬움. Roman to Int 풀어봤으면 날먹임.
class Solution {
    private int[] values = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    private Map<Integer, String> romanMap;
    public String intToRoman(int num) {
        init();
        int length = values.length;
        StringBuilder sb = new StringBuilder();
        for (int i = length-1; i >= 0; i--) {
            while (num >= values[i]) {
                num -= values[i];
                sb.append(romanMap.get(values[i]));
            }
        }
        return sb.toString();
    }

    private void init() {
        romanMap = new HashMap<>();
        romanMap.put(1, "I");
        romanMap.put(4, "IV");
        romanMap.put(5, "V");
        romanMap.put(9, "IX");
        romanMap.put(10, "X");
        romanMap.put(40, "XL");
        romanMap.put(50, "L");
        romanMap.put(90, "XC");
        romanMap.put(100, "C");
        romanMap.put(400, "CD");
        romanMap.put(500, "D");
        romanMap.put(900, "CM");
        romanMap.put(1000, "M");
    }
}
