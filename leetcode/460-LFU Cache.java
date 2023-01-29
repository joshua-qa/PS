// 103ms. 디스크립션이 너무 불친절하고 불명확한 것들이 있다.. 다음부터 이런건 풀지 말아야하나
class LFUCache {
    private Map<Integer, Element> cache;
    private TreeSet<Element> cacheTable;
    private int capacity;
    private int methodCallCount;
    public LFUCache(int capacity) {
        this.cache = new HashMap<>();
        this.cacheTable = new TreeSet<>(new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                if (o1.getUseCount() == o2.getUseCount()) {
                    if (o1.getLastCall() == o2.getLastCall()) {
                        return o1.getKey() - o2.getKey();
                    }
                    return o1.getLastCall() - o2.getLastCall();
                }
                return o1.getUseCount() - o2.getUseCount();
            }
        });
        this.capacity = capacity;
    }

    public int get(int key) {
        if (capacity == 0) {
            return -1;
        }
        methodCallCount++;
        if (!cache.containsKey(key)) {
            return -1;
        }
        Element cacheData = cache.get(key);
        cacheTable.remove(cacheData);
        cacheData.setLastCall(methodCallCount);
        cacheData.incrementUseCount();
        cacheTable.add(cacheData);
        return cacheData.getValue();
    }
    
    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        methodCallCount++;
        if (cache.containsKey(key)) {
            Element cacheData = cache.remove(key);
            cacheTable.remove(cacheData);
            cacheData.incrementUseCount();
            cacheData.setLastCall(methodCallCount);
            cacheData.setValue(value);
            cacheTable.add(cacheData);
            cache.put(key, cacheData);
            return;
        }

        Element newCacheData = new Element(key, value, methodCallCount);
        if (cache.keySet().size() == capacity) {
            Element removeCacheData = cacheTable.pollFirst();
            cache.remove(removeCacheData.getKey());
        }

        cache.put(key, newCacheData);
        cacheTable.add(newCacheData);
    }
}

class Element {
    private int key;
    private int value;
    private int useCount;
    private int lastCall;

    public Element(int key, int value, int lastCall) {
        this.key = key;
        this.value = value;
        this.useCount = 1;
        this.lastCall = lastCall;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    public int getUseCount() {
        return useCount;
    }

    public int getLastCall() {
        return lastCall;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setLastCall(int lastCall) {
        this.lastCall = lastCall;
    }

    public void incrementUseCount() {
        this.useCount++;
    }

    @Override
    public String toString() {
        return "Element{" +
                "key=" + key +
                ", value=" + value +
                ", useCount=" + useCount +
                ", lastCall=" + lastCall +
                '}';
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
