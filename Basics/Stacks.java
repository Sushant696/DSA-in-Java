package Basics;

public class Stacks {
  int[] stk;
  int top = -1;
  static int size;

  Stacks(int size) {
    stk = new int[size];
    this.size = size;
  }

  void push(int data) {

    if (isFull()) {
      System.out.println("Stack overflow");
    } else {
      stk[++top] = data;
    }
  }

  int pop() {
    if (isEmpty()) {
      System.out.println("Stack is empty");
      return -99;
    }
    return stk[top--];
  }

  boolean isEmpty() {
    return top == -1;
  }

  boolean isFull() {
    return top == size - 1; // return true if at top at last index
  }

  public static void main(String[] args) {
    Stacks s = new Stacks(size);
    s.push(10);
    System.out.println();

  }
}
