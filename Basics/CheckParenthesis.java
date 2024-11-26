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
      } 
      else if (closedBraces.indexOf(ch) != -1) {
      
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

