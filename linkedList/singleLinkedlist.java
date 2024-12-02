package linkedList;
/**
 * singleLinkedlist
 */
public class singleLinkedlist {
  // define head and tail instances of the node
  public Node head = null;
  public Node tail = null;

  // add node function to add a new node
  public void addNode(int data) {
    // creating new node
    Node newNode = new Node(data);

    // checking if the list is empty -> if the head is null
    if (head == null) {
      head = newNode;
      tail = newNode;
    } else {
      // why we are doing this why update tail.next and tail to point to newNode
      tail.next = newNode;
      tail = newNode;
    }

  }

  public void printList() {
    Node current = head;
    while (current != null) {
      System.out.println(current.data);
      current = current.next;
    }

  }

  public static void main(String[] args) {
    singleLinkedlist list = new singleLinkedlist();
    list.addNode(10);
    list.addNode(20);
    list.addNode(30);
    list.printList();
  }
}
