package caching;

import java.util.HashMap;

/**
 * LRUcaching
 */
public class LRUcaching {

  // node struct
  public static class Node {
    int k;
    int v;
    Node next;
    Node prev;

    Node(int key, int value) {
      this.k = key;
      this.v = value;
      this.next = this.prev = null;
    }
  }

  int capacity;
  HashMap<Integer, Node> map;

  // LRU constructor
  LRUcaching(int capacity) {
    this.capacity = capacity;
    map = new HashMap<>();
  }

  void put(int key, int value) {
    if (map.containsKey(key)) {
      // remove associated node and key from both the linked list and hasmap
      removeNode(map.get(key));
    }

    if (map.size() == capacity) {
      removeNode(dummyTail.prev);
    }
    Node newNode = new Node(12, value);
    insert(newNode);
  }

  Node dummyHead = new Node(0, 0);
  Node dummyTail = new Node(0, 0);

  void insert(Node newNode) {

    map.put(newNode.k, newNode);
    // if the linked list is empty of this is the first element
    if (dummyHead.next == null) {
      newNode.prev = dummyHead;
      newNode.next = dummyTail;
      dummyHead.next = newNode;
      dummyTail.prev = newNode;
    }

    else {
      newNode.next = dummyHead.next;
      dummyHead.next.prev = newNode;
      newNode.prev = dummyHead;
      dummyHead.next = newNode;
    }
  }

  int get(int key) {
    Node node = map.get(key);

    if (node != null) {
      // remove node
      removeNode(node);
      // re insert the same node in head firsts
      insert(node);
      return node.v;
    }
    return -1;
  }

  void removeNode(Node node) {
    map.remove(node.k);
    node.prev.next = node.next;
    node.next.prev = node.prev;

    node.next = node.prev = null;
  }

  public static void main(String[] args) {
    LRUcaching caching = new LRUcaching(3);
  }
}
