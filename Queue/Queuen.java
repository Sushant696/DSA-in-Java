package Queue;

/**
 * Queuen
 */
public class Queuen {
  int queue[];
  int size;
  int front = -1;
  int rear = -1;

  Queuen(int size) {
    // getting the size and making arrar of name queue
    this.size = size;
    queue = new int[size];
  }

  // insert into queue (enqueue)

  void enqueue(int data) {

    if (isFull()) {
      System.out.println("Queue is full");
    } else {
      // making the front 0 from the -1
      if (front == -1) {
        front = 0;
      }
      queue[++rear] = data;
    }
  }

  int dequeue() {
    System.out.println("This really ran");
    if (isEmpty()) {
      System.out.println("The queue is empty");
      return -1;
    }
    if (front == rear) {
      int temp = front;
      front = rear = -1;
      return queue[temp];
    }
    // if the queue is not empty and then front and rear are also not equall just
    // increment the front which means dequeue
    return queue[front++];
  }

  boolean isFull() {
    return rear == size - 1;
  }

  boolean isEmpty() {
    return front == -1 && rear == -1;
  }


  // there will be still elements in the 
  public void printQueue() {
    for (int i = front; i <= rear; i++) {
      System.out.print(queue[i]);
    }
  }

  public static void main(String[] args) {
    Queuen Queue = new Queuen(5);
    Queue.enqueue(10);
    Queue.enqueue(20);
    Queue.enqueue(30);
    Queue.enqueue(40);
    Queue.enqueue(50);

    Queue.dequeue();
    Queue.dequeue();
    Queue.dequeue();
    Queue.dequeue();

    Queue.printQueue();
  }
}
