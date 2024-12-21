package linkedList;

/**
 * circularLinkedList
 */
public class circularLinkedList {

  static class Node {
    Node next;
    Node prev;
    int data;

    Node(int data) {
      this.data = data;
      this.prev = null;
      this.next = null;
    }
  }

  Node head = null;
  Node tail = null;

  void insertNode(int data) {
    Node newNode = new Node(data);
    if (head == null) {
      System.out.println();
      head = newNode;
      tail = newNode;
      newNode.next = newNode.prev = newNode;
    } else {
      newNode.prev = tail;
      newNode.next = head;
      head.prev = newNode;
      tail.next = newNode;
      tail = newNode;
    }
  }

  void print() {
    if (head == null)
      return;

    Node current = head;
    do {
      System.out.println(current.data);
      current = current.next;
    } while (current != head);
  }

  // implementing circular linkedList
  public static void main(String[] args) {
    circularLinkedList list = new circularLinkedList();
    list.insertNode(12);
    list.insertNode(2);
    list.insertNode(22);
    list.print();
  }
}
