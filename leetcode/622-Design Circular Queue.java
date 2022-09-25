// 7ms. 연습해둬서 나쁠게 전혀 없는 구현 문제
class MyCircularQueue {
    private int[] queue;
    private int front, tail, size;
    public MyCircularQueue(int k) {
        queue = new int[k];
    }

    public boolean enQueue(int value) {
        if (size == queue.length) {
            return false;
        }
        tail = (tail + 1) % queue.length;
        if (isEmpty()) {
            front = tail;
        }
        queue[tail] = value;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (size == 0) {
            return false;
        }
        queue[front] = -1;
        front = (front + 1) % queue.length;
        size--;
        if (isEmpty()) {
            tail = front;
        }
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return queue[front];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return queue[tail];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == queue.length;
    }
}
