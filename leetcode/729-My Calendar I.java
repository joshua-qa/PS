// 43ms. 문제 재밌다. 나름 쉽게 풀려고 TreeMap 썼는데 덕분에 메서드 사용법 잘 배움
class MyCalendar {
    TreeMap<Integer, Integer> times;
    public MyCalendar() {
        times = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        if (times.isEmpty()) {
            times.put(start, end);
            return true;
        }

        Integer floor = times.floorKey(start);
        Integer ceiling = times.ceilingKey(start);
        boolean isAvailable = true;
        if (floor != null) {
            Integer floorEnd = times.get(floor);
            if (floor == start || floorEnd > start) {
                isAvailable = false;
            }
        }
        if (ceiling != null) {
            Integer ceilingEnd = times.get(ceiling);
            if (ceiling < end || ceilingEnd <= end) {
                isAvailable = false;
            }
        }
        if (isAvailable) {
            times.put(start, end);
        }
        return isAvailable;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
