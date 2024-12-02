package linkedList;

/**
 * LinkedList
 */
public class LinkedList {
  // variable init
  Node head = null;
  Node tail = null;

  // addNewNode
  public Node addNewNode(int data) {
    Node newNode = new Node(data);
    if (head == null) {
      head = newNode;
      tail = newNode;
    } else {
      tail.next = newNode;
      tail = newNode;
    }
    return newNode;
  }

  // print list
  void printList() {
    Node current = head;
    while (current != null) {
      System.out.println(current.data);
      current = current.next;
    }
  }

  // delete last node
  void deleteLastNode() {
    if (head == null) {
      System.out.println("The list is empty nothing to delete :)");
    }

    // if List has only one node
    if (head == tail) {
      head = null;
      tail = null;
      return;
    }

    Node current = head;
    while (current.next != tail) {
      current = current.next;
    }

    current.next = null;
    tail = current;
  }

  // headFirstInsert
  public void headFirstInsert(int data) {
    Node newNode = new Node(data);
    if (head == null) {
      head = tail = newNode;
    } else {
      newNode.next = head;
      head = newNode;
    }
  }

  // insertAtAnyPos
  public void insertAtAnyPos(int data, int pos) {
    Node newNode = new Node(data);
    Node current = head;
    for (int i = 2; i < pos; i++) {
      current = current.next;
      newNode.next = current.next;
      current.next = newNode;
    }
  }

  // deleteAtAnyPos
  public void deleteAtAnyPos(int pos) {
    Node current = head;
    if (pos == 1) {
      Node temp = head;
      head = head.next;
      temp.next = null;
    }

    else {
      for (int i = 1; i < pos - 1; i++) {
        current = current.next;
      }
      Node temp = current.next;
      current.next = temp.next;
      temp.next = null;

    }
  }

  // insertBefore

  public void insertBefore(Node node, int data) {
    Node newNode = new Node(data);
    Node current = head;
    while (current.next != node) {
      current = current.next;
    }
    newNode.next = current.next;
    current.next = newNode;
  }

  public void deleteBefore(Node node) {
    Node current = head;
    while (current.next.next != node) {
      current = current.next;
    }
    Node temp = current.next;
    current.next = temp.next;
    temp.next = null;

  }

  public void insertAfter(Node node, int data) {
    Node newNode = new Node(data);
    Node current = head;
    while (current != null && current != node) {
      current = current.next;
    }
    newNode.next = current.next;
    current.next = newNode;
  }

  public void deleteAfter(Node node) {
    Node current = head;
    while (current != node) {
      current = current.next;
    }
    Node temp = current.next;
    current.next = temp.next;
    temp.next = null;
  }
  // making linked list with all the methods avaliable
  // insertAfter
  // deleteBefore
  // deleteAfter

  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    Node node1 = list.addNewNode(10);
    Node newNode = list.addNewNode(20);
    list.addNewNode(30);
    Node node = list.addNewNode(40);
    list.insertBefore(node, 80);
    list.deleteLastNode();
    list.addNewNode(30);
    list.deleteAfter(newNode);
    list.headFirstInsert(40);
    list.insertAtAnyPos(50, 3);
    Node node2 = list.addNewNode(40);
    list.insertAfter(node1, 70);
    list.deleteAtAnyPos(1);
    list.deleteBefore(node2);
    list.addNewNode(100);
    list.printList();
  }
}
