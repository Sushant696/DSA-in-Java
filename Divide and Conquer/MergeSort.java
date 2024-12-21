/**
 * MergeSort
 */
public class MergeSort {

  private static void mergeSort(int a[], int s, int e) {
    if (s < e) {
      int m = (s + e) / 2;
      // calling merge sort for left tree
      mergeSort(a, s, m);
      // calling merge sort for right tree
      mergeSort(a, m + 1, e);
      merge(a, s, m, e);
    }
  }

  private static void merge(int a[], int s, int m, int e) {

    // making two array and populate the array value of left and right subarrays

    int lArr[] = new int[m - s + 1];
    int rArr[] = new int[e - m];

    // put all the left values to the left array
    for (int i = 0; i < lArr.length; i++) {
      lArr[i] = a[i + s];
    }
    // put all the right values to the right array
    for (int i = 0; i < rArr.length; i++) {
      rArr[i] = a[m + 1 + i];
    }

    // now making the pointer and helper variable to store the position upto where
    // the correct values are stored.
    int i = 0;
    int j = 0;
    // helper starts with zero
    int helper = s;

    // now comparing the left and right array i and j index value;
    while (i < lArr.length && j < rArr.length) {
      if (lArr[i] < rArr[j]) {
        a[helper] = lArr[i];
        i++;
        helper++;
      } else {
        a[helper] = rArr[j];
        j++;
        helper++;
      }
    }

    // Copy remaining elements from left array, if any
    while (i < lArr.length) {
      a[helper] = lArr[i];
      i++;
      helper++;
    }

    // Copy remaining elements from right array, if any
    while (j < rArr.length) {
      a[helper] = rArr[j];
      j++;
      helper++;
    }
  }

  public static void main(String[] args) {
    int arr[] = { 1, 5, 3, 4, 2, 434, 2443 };
    mergeSort(arr, 0, arr.length - 1);
    for (int i : arr) {
      System.out.println(i);
    }
  }
}
