package Array;

import java.util.Scanner;

/**
 * Rightshift
 */
public class Rightshift {

  static void rightShift(int arr[], int n, int rs) {
    for (int k = 0; k < rs; k++) {
      for (int i = n - 1; i > 0; i--) {
        arr[i] = arr[i - 1];
      }
      arr[k] = 0;
    }

    for (int i : arr) {
      System.out.print(i);
    }

  }

  public static void main(String[] args) {

    int arr[] = { 10, 20, 30, 40, 50 };
    int n = arr.length;
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter how many times you want to right shift array elements");
    int ls = sc.nextInt();
    sc.close();
    System.out.println("Initially");
    for (int i : arr) {
      System.out.println(i);
    }
    rightShift(arr, n, ls);
    System.out.println("After shifting");
  }
}
