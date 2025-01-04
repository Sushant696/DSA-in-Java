package caching;

public class Stacks {
  char[] stk;
  int top = -1;
  static int size;

  Stacks(int size) {
    stk = new char[size];
    this.size = size;
  }

  void push(char data) {

    if (isFull()) {
      System.out.println("Stack overflow");
    } else {
      stk[++top] = data;
    }
  }

  char pop() {
    if (isEmpty()) {
      System.out.println("Stack is empty");
      return 'f';
    }
    return stk[top--];
  }

  boolean isEmpty() {
    return top == -1;
  }

  char peek() {
    return stk[top];
  }

  boolean isFull() {
    return top == size - 1; // return true if at top at last index
  }

  public static void main(String[] args) {
    Stacks s = new Stacks(size);
    s.push('1');
    System.out.println();

  }
}

// write an algo to convert infix to prefix and vice versa
// Write an algorithm to evaluate postfix algorithm
