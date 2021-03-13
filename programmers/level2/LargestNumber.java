public String solution(int[] numbers) {
    Comparator<Integer> integerComparator = (o1, o2) -> {
        String s1 = String.valueOf(o1) + o2;
        String s2 = String.valueOf(o2) + o1;
        return Integer.parseInt(s2) - Integer.parseInt(s1);
    };
    List<Integer> sortedList = new ArrayList<>();
    for (int number : numbers) {
        sortedList.add(number);
    }
    sortedList.sort(integerComparator);

    StringBuilder sb = new StringBuilder();
    for (int num : sortedList) {
        sb.append(num);
    }
    String result = sb.toString();
    if (result.charAt(0) == '0') {
        return "0";
    }
    return result;
}