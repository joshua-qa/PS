// 397ms. TreeMap 쓸줄 알면 날로 먹을 수 있다.
class TimeMap {
    private Map<String, TreeMap<Integer, String>> timeMap;
    private final String EMPTY = "";
    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (timeMap.containsKey(key)) {
            timeMap.get(key).put(timestamp, value);
            return;
        }
        TreeMap<Integer, String> valueMap = new TreeMap<>();
        valueMap.put(timestamp, value);
        timeMap.put(key, valueMap);
    }
    
    public String get(String key, int timestamp) {
        if (!timeMap.containsKey(key)) {
            return EMPTY;
        }
        TreeMap<Integer, String> valueMap = timeMap.get(key);
        Integer floorKey = valueMap.descendingKeySet().ceiling(timestamp);
        if (floorKey == null) {
            return EMPTY;
        }
        return valueMap.get(floorKey);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
