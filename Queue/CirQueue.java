package Queue;

/**
 * CirQueue
 */

public class CirQueue {
  int size;
  int front;
  int rear;
  int queue[];
  int newVariable = 122;

  CirQueue(int size) {
    this.size = size;
    front = rear = -1;
    queue = new int[size];
  }

  void enQueue(int data) {
    if (isFull()) {
      System.out.println("The queue is full");
    } else {
      if (isEmpty()) {
        front = 0;
      }
      rear = (rear + 1) % size;
      queue[rear] = data;
    }
    // (rear + 1) % size makes rear to go from last index to zero and makebe
    // circular
  }

  int dequeue() {
    if (isEmpty()) {
      System.out.println("The queue is empty");
      return -1;
    }

    int temp = front;
    if (front == rear) {
      front = rear = -1;
      return queue[temp];
    }
    front = (front + 1) % size;
    return queue[temp];
  }

  boolean isFull() {
    return (rear + 1) % size == front;
  }

  boolean isEmpty() {
    return front == -1 && rear == -1;
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

    System.out.print(queue[rear]+"\n");
  }

  public static void main(String[] args) {
    CirQueue cq = new CirQueue(4);
    cq.enQueue(1);
    cq.enQueue(10);
    cq.enQueue(100);
    cq.enQueue(1000);
    cq.printQueue();
    cq.enQueue(10000);
    cq.dequeue();
    cq.dequeue();
    cq.dequeue();
    cq.printQueue();
    cq.dequeue();
    cq.printQueue();
  }
}
