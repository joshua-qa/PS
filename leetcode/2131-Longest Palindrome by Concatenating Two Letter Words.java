// 62ms. 엄청 재밌고 생각해볼만한 문제였다.
class Solution {
    /**
     1그룹) 성립 안되는 케이스
     -> 앞뒤가 다르면서 뒤앞 문자열이 없는 경우

     2그룹) 앞뒤가 똑같은 문자열 (성립 되는 케이스)
     aa나 aaaa나 aaaaaa나 가운데에 넣어서 팰린드롬을 만들 수 있기 때문에

     2그룹들 중에서 가장 갯수가 큰 것을 전부 다 사용할 수 있고

     나머지 그룹들은 짝수 단위로 잘라서 쓸 수 있다.

     3그룹) 성립 되는 케이스
     -> 앞뒤가 다르지만 뒤앞 문자열도 존재하는 경우

     앞뒤랑 뒤앞의 갯수가 같아야하며 같지 않은 경우는 Math.min(앞뒤, 뒤앞) 만큼 가져다 쓸 수 있음.
     어차피 이 페어가 성립해야만 가져다 쓸 수 있지 짝홀 여부는 관계없으므로 최대한 많이 가져다 쓸 수 있음.
     */
    public int longestPalindrome(String[] words) {
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            int prev = count.getOrDefault(word, 0);
            count.put(word, prev+1);
        }

        int result = 0;
        Map<String, Boolean> visit = new HashMap<>();
        List<Integer> doubleGroupCounts = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            char[] key = entry.getKey().toCharArray();
            if (key[0] == key[1]) {
                visit.put(entry.getKey(), true);
                doubleGroupCounts.add(entry.getValue());
                continue;
            }

            String reverseKey = String.valueOf(new char[]{key[1], key[0]});
            if (!count.containsKey(reverseKey)) {
                visit.put(entry.getKey(), true);
                continue;
            }

            if (visit.containsKey(entry.getKey()) || visit.containsKey(reverseKey)) {
                continue;
            }

            visit.put(entry.getKey(), true);
            visit.put(reverseKey, true);
            int min = Math.min(entry.getValue(), count.get(reverseKey));
            result += min * 4;
        }

        Collections.sort(doubleGroupCounts);
        int size = doubleGroupCounts.size();
        boolean useOdd = false;
        for (int i = size-1; i >= 0; i--) {
            int curr = doubleGroupCounts.get(i);
            if ((curr & 1) == 1) {
                if (!useOdd) {
                    useOdd = true;
                    result += curr * 2;
                    continue;
                }
                result += (curr-1) * 2;
            } else {
                result += curr * 2;
            }
        }
        return result;
    }
}
