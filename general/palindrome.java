// Write a program to find if the number input by the user is palindrome or not..
// Palindrome number remains the same when it's digits are reversed

package general;

import java.util.Scanner;

/**
 * palindrome
 */
public class palindrome {

  public static void main(String[] args) {
    Scanner s1 = new Scanner(System.in);
    System.out.println("Enter a number to check if it is palindrome or not.");
    int input = s1.nextInt();
    s1.close();
    int rem;
    int rev = 0;

    // steps involved
    // Reverse the number digit by digit and check if the original number and the
    // Check reversed and original number are same nor not.

    int originalNum = input;
    while (input > 0 || input != 0) {
      rem = input % 10;
      System.out.println(rem + ": rem");
      rev = rev * 10 + rem;
      System.out.println(rev + ": rev");
      input = input / 10;
      System.out.println(input + ": input");
    }
    if (originalNum == rev) {

      System.out.println("The number " + rev + " is palindrome");
    } else {
      System.out.println("The number you entered is not palindrome.");
    }

  }
}
