package Basics;

/**
 * Queue
 */
public class Queue {
  int queue[];
  int size;
  int front = -1;
  int rear = -1;

  Queue(int size) {
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
      queue[++rear] = data;
    }
  }

  int dequeqe() {

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

  boolean isFull() {
    return rear == size - 1;
  }

  boolean isEmpty() {
    return rear == -1 && front == -1;
  }

  public static void main(String[] args) {
    System.out.println("");
  }
}

