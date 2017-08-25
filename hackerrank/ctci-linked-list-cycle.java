// 2017.08.25
// 풀긴 풀었지만 나중에 다시 풀어봐야할 문제. 알고보니 플로이드의 순환 검출법을 사용하면 되는 문제였다.
boolean hasCycle(Node head) {
    ArrayList<Node> visit = new ArrayList<>();
    if(head == null) {
        return false;
    }
    Node curr = head;
    while(curr != null) {
        if(!visit.contains(curr)) {
            visit.add(curr);
            curr = curr.next;
        } else {
            return true;
        }
    }
    return false;
}