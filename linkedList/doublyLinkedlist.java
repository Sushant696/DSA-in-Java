package linkedList;

/**
 * doublyLinkedlist
 */
public class doublyLinkedlist {

  public static class Node {
    Node prev;
    Node next;
    int data;

    Node(int data) {
      this.data = data;
      this.prev = this.next = null;
    }
  }

  Node head = null;
  Node tail = null;

  void insert(int data) {
    Node newNode = new Node(data);
    if (head == null) {
      head = tail = newNode;
    } else {
      tail.next = newNode;
      newNode.prev = tail;
      tail = newNode;
    }
  }

  void printList() {
    Node current = head;
    while (current != null) {
      System.out.println(current.data);
      current = current.next;
    }
  }

  public static void main(String[] args) {
    doublyLinkedlist list = new doublyLinkedlist();
    list.insert(10);
    list.insert(20);
    list.printList();

  }
}
