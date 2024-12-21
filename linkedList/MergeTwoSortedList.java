package linkedList;

/**
 * MergeTwoSortedList
 */
public class MergeTwoSortedList {

  public static class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  Node head = null;

  void insertNode(int data) {
    Node curr = head;
    if(head == null) {
      
    }

  }

  public static void main(String[] args) {
     MergeTwoSortedList list1 = new MergeTwoSortedList();
   //  MergeTwoSortedList list2 = new MergeTwoSortedList();
    list1.insertNode(12);
  }
}
