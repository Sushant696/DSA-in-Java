package Backtracking;

/**
 * Permutation
 */
public class Permutation {

  static void FindPermutations(String str, String permutation) {
    if (str.length() == 0) {
      System.out.println(permutation);
      return;
    }
    for (int i = 0; i < str.length(); i++) {
      // extracting the individual character
      char currChar = str.charAt(i);
      // getting the remaining subString
      String remainStr = str.substring(0, i) + str.substring(i + 1);
      // recursion for backtracking
      FindPermutations(remainStr, permutation + currChar);
    }
  }





  public static void main(String[] args) {
    String str = "abc";
    String permutation = " ";
    FindPermutations(str, permutation);
  }
}
