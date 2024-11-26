package general;

/**
 * prime
 */

// find the number 11 is prime or not

public class prime {
  public static void main(String[] args) {

    int num = 9;
    for (int i = 2; i < num; i++) {
      if (num % i == 0) {
        System.out.println(num + "%" + i + "=" + num % i);
        System.out.println("The number " + num + " is not prime");
        break;
      }
    }
  }
}
