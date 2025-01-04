package linkedList;

/**
 * MergeTwoSortedList
 */
public class MergeTwoSortedList {

  public static class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
      this.data = data;
      this.next = null;
    }
  }

  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    // first traverse through the linked list
    // creating new list

    ListNode dummyHead = new ListNode(0);
    ListNode current = dummyHead;

    if (list1 == null) {
      return list2;
    }
    if (list2 == null) {
      return list1;
    }

    while (list1 != null && list2 != null) {
      if (list1.data >= list2.data) {
        current.next = list2;
        list2 = list2.next;
      } else {
        current.next = list1;
        list1 = list1.next;
      }
      current = current.next;
    }
    // storing the remaining items in the new linked list
    current.next = (list1 != null) ? list1 : list2;
    return dummyHead.next;
  }

  public static void main(String[] args) {
    MergeTwoSortedList list1 = new MergeTwoSortedList();
    // MergeTwoSortedList list2 = new MergeTwoSortedList();
  }
}
