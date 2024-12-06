package Array;

public class array {
  static void InsertIntoArray(int a[], int p, int d, int n) {

    for (int i = n; i > p - 1; i--) {
      a[i] = a[i - 1]; // at the last index initially
    }

    a[p] = d;
    n++;
    for (int i : a) {
      
    }

  }

  public static void main(String[] args) {
    int arr[] = new int[6];
    arr[0] = 10;
    arr[1] = 20;
    arr[2] = 30;
    arr[3] = 40;
    arr[4] = 50;

    // [10,20,30,30,40,50]

    int p = 3; // position
    int n = 5; // no of elements present initially
    int d = 80; // data to be added

    InsertIntoArray(arr, p, d, n);

  }
}
