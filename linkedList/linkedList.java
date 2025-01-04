package linkedList;

/**
 * linkedList
 */
public class linkedList {

  public static class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  Node head = null;
  Node tail = null;

  void addNode(int data) {
    Node newNode = new Node(data);

    if (head == null) {
      head = newNode;
      tail = newNode;
    } else {
      // Node current = head;
      // while (current.next != null) {
      // current = current.next;
      // }
      // current.next = newNode;
      //
      tail.next = newNode;
      tail = newNode;
    }
  }

  @SuppressWarnings("unused")
  void addHeadFirst(int data) {
    Node newNode = new Node(data);
    if (head == null) {
      head = tail = newNode;
    } else {
      newNode.next = head;
      head = newNode;
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
    linkedList list = new linkedList();
    list.addNode(10);
    list.addNode(20);
    list.addNode(30);
    list.printList();
  }

}
