package Queue;

/**
 * CircularQueue
 */
public class CircularQueue {

  int front = -1;
  int rear = -1;
  int size;
  int queue[];

  CircularQueue(int size) {
    this.size = size;
    queue = new int[size];
  }

  void enqueue(int data) {
    if (isFull()) {
      System.out.println("Queue is full");
    } else {
      if (front == -1) {
        front = 0;
      }
      rear = (rear + 1) % size;
      queue[rear] = data;
    }
  }

  int dequeue() {
    if (isEmpty()) {
      System.out.println("Queue is empty");
      return -1;
    }

    int temp = queue[front];
    if (front == rear) {
      // if the item present is the last item of the queue.
      front = rear = -1;
    } else {
      front = (front + 1) % size;
    }
    return temp;
  }

  boolean isEmpty() {
    return front == -1 && rear == -1;
  }

  boolean isFull() {
    return (rear + 1) % size == front;
  }

  void printQueue() {
    if (isEmpty()) {
      System.out.println("The queue is empty");
      return;
    }
    System.out.print("Queue: ");
    for (int i = front; i != rear; i = (i + 1) % size) {
      System.out.print(queue[i] + " ");
    }

    System.out.print(queue[rear]);
    System.out.println();
  }

  public static void main(String[] args) {
    CircularQueue cq = new CircularQueue(4);
    cq.enqueue(1);
    cq.enqueue(10);
    cq.enqueue(100);
    cq.enqueue(1000);
    cq.printQueue();
    cq.enqueue(10000);
    cq.dequeue();
    cq.dequeue();
    cq.dequeue();
    cq.printQueue();
    cq.dequeue();
  }
}
