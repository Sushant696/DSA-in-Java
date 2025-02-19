package Queue;

/**
 * Queue
 */
public class Queue {

    int queue[];
    int size;
    int front = -1;
    int rear = -1;

    public Queue(int size) {
        this.size = size;
        queue = new int[size];
    }

    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else {
            if (front == -1) {
                front = 0;
            }
            queue[++rear] = data;
        }
    }

    public int dequeqe() {

        if (isEmpty()) {
            System.out.println("Queue is Empty..");
            return -1;
        }
        if (front == rear) {
            int temp = front;
            front = rear = -1;
            return queue[temp];
        }
        return queue[front++];
    }

    public boolean isFull() {
        return rear == size - 1;
    }

    public boolean isEmpty() {
        return rear == -1 && front == -1;
    }

    public static void main(String[] args) {
        System.out.println("");
    }
}
