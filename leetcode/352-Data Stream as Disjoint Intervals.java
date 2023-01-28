// 90ms. 디스크립션이 조금 불친절한 문제였다. 문제 푸는데 꼭 필요한 설명을 생략한 덕분에 푸는 사람이 추측해야하는 사항이 있었음.
// 삽입했을 때 발생하는 케이스들을 쭉 나열해보면 쉽게 풀 수 있다.
class SummaryRanges {
    private TreeSet<Interval> stream;
    private boolean[] exist;
    private int streamSize;
    public SummaryRanges() {
        stream = new TreeSet<>();
        exist = new boolean[10001];
        streamSize = 0;
    }
    
    public void addNum(int value) {
        if (exist[value]) {
            return;
        }
        exist[value] = true;
        Interval curr = new Interval(value, value);

        Interval left = stream.floor(curr);
        Interval right = stream.ceiling(curr);
        if (left != null && left.equals(right)) {
            if (!isNear(curr, left)) {
                stream.add(curr);
                streamSize = stream.size();
                return;
            }
            stream.remove(left);
            curr = mergeInterval(curr, left);
            stream.add(curr);
            streamSize = stream.size();
            return;
        }

        if (!isNear(curr, left) && !isNear(curr, right)) {
            stream.add(curr);
            streamSize = stream.size();
            return;
        }

        if (isNear(curr, left)) {
            stream.remove(left);
            curr = mergeInterval(curr, left);
        }

        if (isNear(curr, right)) {
            stream.remove(right);
            curr = mergeInterval(curr, right);
        }

        stream.add(curr);
        streamSize = stream.size();
    }
    
    public int[][] getIntervals() {
        int[][] streamView = new int[streamSize][2];
        int index = 0;
        for (Interval interval : stream) {
            streamView[index][0] = interval.getStart();
            streamView[index++][1] = interval.getEnd();
        }
        return streamView;
    }

    private boolean isNear(Interval curr, Interval target) {
        if (target == null) {
            return false;
        }
        return curr.getEnd() + 1 == target.getStart() || curr.getStart() - 1 == target.getEnd();
    }

    private Interval mergeInterval(Interval curr, Interval target) {
        int newStart = Math.min(curr.getStart(), target.getStart());
        int newEnd = Math.max(curr.getEnd(), target.getEnd());
        return new Interval(newStart, newEnd);
    }
}

class Interval implements Comparable<Interval> {
    private int start;
    private int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    @Override
    public int compareTo(Interval o) {
        return this.start - o.start;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */
