package practiceQuestion;

public class Q {

    int queue[];
    int size;
    int front, rear = -1;

    public Q(int size) {
        queue = new int[size];
        this.size = size;
    }

    void enQueue(int data) {
        if (isFull()) {
            System.out.println("queue is full");
            return;

        }
        if (front == -1) {
            front = 0;
        }
        queue[++rear] = data;
    }

    int deQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        if (front == rear) {
            System.out.println("front and rear equall");
            // if in same position that mean the item is last so we just remove that item and reset the queue
            int temp = front;
            front = rear = -1;
            return queue[temp];
        }
        return queue[front++];
    }

    boolean isFull() {
        return rear == size - 1;
    }

    boolean isEmpty() {
        return rear == -1 && front == -1;
    }

    public static void main(String[] args) {
        Q q = new Q(3);

        q.enQueue(2);
        q.enQueue(4);
        q.enQueue(6);
        q.enQueue(8);  // Should print "Queue is full"

        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();
    }

}
