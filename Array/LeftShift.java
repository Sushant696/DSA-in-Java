package Array;

import java.util.Scanner;

/**
 * LeftShift
 */

public class LeftShift {

  static void leftShiftMethod(int arr[], int n, int ls) {
    System.out.println("This is left shift method");

    // [1,2,3,4,5] [2,3,4,5,0]
    for (int k = 0; k < ls; k++) {
      for (int i = 0; i < n - 1; i++) {
        arr[i] = arr[i + 1];
      }
      arr[n - 1] = 0;
    }

    for (int i : arr) {
      System.out.print(i + " ");
    }
  }

  public static void main(String[] args) {
    int arr[] = { 1, 2, 3, 4, 5 };
    int n = arr.length;
    Scanner sc = new Scanner(System.in);
    System.out.println("Please Enter how many times you want to shift beat");
    int leftShiftNum = sc.nextInt();
    sc.close();
    leftShiftMethod(arr, n, leftShiftNum);
  }
}
