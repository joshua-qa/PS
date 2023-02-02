// 4ms. 이런 문제는 또 처음이네...
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> table = new HashMap<>();
        int index = 0;
        int length = words.length;
        for (char c : order.toCharArray()) {
            table.put(c, index++);
        }

        String[] origin = Arrays.copyOf(words, length);
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.equals(o2)) {
                    return 0;
                }

                int minLength = o1.length() > o2.length() ? o2.length() : o1.length();

                for (int i = 0; i < minLength; i++) {
                    int o1Level = table.get(o1.charAt(i));
                    int o2Level = table.get(o2.charAt(i));
                    if (o1Level == o2Level) {
                        continue;
                    }
                    if (o1Level > o2Level) {
                        return 1;
                    }
                    return -1;
                }

                return o1.length() > o2.length() ? 1 : -1;
            }
        });

        for (int i = 0; i < length; i++) {
            if (!origin[i].equals(words[i])) {
                return false;
            }
        }
        return true;
    }
}
