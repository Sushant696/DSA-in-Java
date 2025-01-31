package Basics;

public class CheckParenthesis {

  static boolean checkParenthesis(String exp) {
    Stacks stk = new Stacks(exp.length());
    String openBraces = "[{(";
    String closedBraces = "]})";
    
    for (int i = 0; i < exp.length(); i++) {
      char ch = exp.charAt(i);

      if (openBraces.indexOf(ch) != -1) {
        stk.push(ch);
      } else if (closedBraces.indexOf(ch) != -1) {

        if (stk.isEmpty()) {
          return false; // No matching open bracket
        }
        char openBracket = stk.pop();
        int openIndex = openBraces.indexOf(openBracket);
        int closeIndex = closedBraces.indexOf(ch);

        if (openIndex != closeIndex) {
          return false; // Mismatched brackets
        }
      }
    }

    return stk.isEmpty();
  }

  public static void main(String[] args) {
    String exp = "{[(]}";
    boolean result = checkParenthesis(exp);
    System.out.println("Is the expression balanced? " + result);
  }
}

class Stacks {
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
