package caching;

import java.util.HashMap;

/**
 * Caching
 */
public class Caching {

  public static class Node {
    Node prev, next;
    int key, value;

    Node(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  // linked size and hashmap initialization
  int capacity;
  HashMap<Integer, Node> map;

  Caching(int capacity) {
    this.capacity = capacity;
    map = new HashMap<>();
  }

  Node dummyHead = new Node(0, 0);
  Node dummyTail = new Node(0, 0);

  void put(int key, int value) {
    // check if the key is in the hashMap
    if (map.containsKey(key)) {
      // remove the node and then add as new node in the head side
      removeNode(map.get(key));
    }
    if (map.size() == capacity) {
      map.remove(dummyTail.prev.key);
      removeNode(dummyTail.prev);
      // if the capacity is reached then delete the node near to tail
    }
    // if the node is new then create and add the node
    Node newNode = new Node(key, value);
    insert(newNode);
  }

  int get(int key) {
    Node node = map.get(key);
    // if the node exist return value of the key
    if (node != null) {
      // Move the node to the head (most recently used)
      removeNode(node);
      insert(node);
      return node.value;
    }
    return -1;
  }

  void insert(Node newNode) {
    // if the list is empty
    if (dummyHead.next == null) {
      newNode.prev = dummyHead;
      newNode.next = dummyTail;
      dummyHead.next = newNode;
      dummyTail.prev = newNode;
    }

    // if list is not empty
    else {
      newNode.next = dummyHead.next;
      newNode.prev = dummyHead;
      dummyHead.next.prev = newNode;
      dummyHead.next = newNode;
    }

    map.put(newNode.key, newNode);
  }

  void removeNode(Node node) {
    map.remove(node.key);
    node.prev.next = node.next;
    node.next.prev = node.prev;
    node.next = node.prev = null;
  }

  public static void main(String[] args) {
    System.out.println("hello world");
    Caching cache = new Caching(3);
    cache.put(1, 10);
    cache.put(2, 20);
    cache.put(3, 30);

    System.out.println(cache.get(1));
    cache.put(4, 40);
    System.out.println(cache.get(2));
    System.out.println(cache.get(3));
    cache.put(5, 50);
    System.out.println(cache.get(1));
    System.out.println(cache.get(4));
    System.out.println(cache.get(5));
  }
}
