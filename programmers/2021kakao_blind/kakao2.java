import java.util.*;
class Solution {
    char[] menuCount;
    List<String> sortedOrders;
    Map<String, Integer> courseCountMap;
    Map<Integer, Integer> maximumOrderCount;
    public String[] solution(String[] orders, int[] course) {
        menuCount = new char[26];
        sortedOrders = new ArrayList<>();
        courseCountMap = new HashMap<>();
        maximumOrderCount = new HashMap<>();

        for (String order : orders) {
            char[] menuList = order.toCharArray();
            Arrays.sort(menuList);
            createCourse(menuList, course);
        }

        for (String createdCourse : courseCountMap.keySet()) {
            int courseSize = createdCourse.length();
            int maximumCount = maximumOrderCount.get(courseSize);
            if (maximumCount > 1 && maximumCount == courseCountMap.get(createdCourse)) {
                sortedOrders.add(createdCourse);
            }
        }
        Collections.sort(sortedOrders);
        return sortedOrders.toArray(new String[0]);
    }

    private void createCourse(char[] order, int[] course) {
        for (int courseSize : course) {
            for (int i = 0; i <= order.length - courseSize; i++) {
                createCourse(order, courseSize - 1, i, String.valueOf(order[i]));
            }
        }
    }

    private void createCourse(char[] order, int remainMenuCount, int currentMenuIndex, String currentMenus) {
        if (remainMenuCount == 0) {
            int orderCount = courseCountMap.getOrDefault(currentMenus, 0);
            courseCountMap.put(currentMenus, orderCount + 1);
            int currentMenuSize = currentMenus.length();
            if (maximumOrderCount.getOrDefault(currentMenuSize, 0) < orderCount + 1) {
                maximumOrderCount.put(currentMenuSize, orderCount + 1);
            }
            return;
        }
        for (int i = currentMenuIndex + 1; i <= order.length - remainMenuCount; i++) {
            createCourse(order, remainMenuCount - 1, i, currentMenus + order[i]);
        }
    }
}