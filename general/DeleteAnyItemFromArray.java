package general;

/**
 * DeleteAnyItemFromArray
 */

public class DeleteAnyItemFromArray {

  static void deleteItem(int a[], int n, int p) {

    for (int i = p - 1; i < n - 1; i++) {
      System.out.println(i + " " + a[i]);
      a[i] = a[i + 1];
    }
    a[n - 1] = 0;

    for (int i : a) {
      System.out.println(i);
    }
  }

  public static void main(String[] args) {

    int[] arr = new int[6];
    arr[0] = 10;
    arr[1] = 20;
    arr[2] = 30; // remove this element
    arr[3] = 40;
    arr[4] = 50;
    arr[5] = 60;

    // [10,20,100,30,40,50]

    int p = 3;
    int n = 6;
    deleteItem(arr, n, p);
  }
}
