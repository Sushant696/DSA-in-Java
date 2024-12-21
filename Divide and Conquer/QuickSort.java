/**
 * QuickSort
 */
public class QuickSort {

  private static void swap(int arr[], int index1, int index2) {
    int temp = arr[index1];
    arr[index1] = arr[index2];
    arr[index2] = temp;
  }

  static void quickSort(int a[], int lowIndex, int highIndex) {
    if (lowIndex >= highIndex) {
      return;
    }
    int pivot = a[highIndex];
    int leftPointer = partition(a, lowIndex, highIndex, pivot);

    // here the left pointer means pivot position or the partition point

    swap(a, leftPointer, highIndex); // swaping the partition position with the pivot using high
    quickSort(a, lowIndex, leftPointer - 1);
    quickSort(a, leftPointer + 1, highIndex);
  }

  private static int partition(int a[], int lowIndex, int highIndex, int pivot) {
    int leftPointer = lowIndex;
    int rightPointer = highIndex;

    while (leftPointer < rightPointer) {

      // numbers small then pivot move right of pivot
      while (a[leftPointer] <= pivot && leftPointer < rightPointer) {
        leftPointer++;
      }
      // numbers larger then pivot move left of the pivot
      while (a[rightPointer] >= pivot && leftPointer < rightPointer) {
        rightPointer--;
      }
      if (leftPointer < rightPointer) {

        swap(a, leftPointer, rightPointer);

      }
    }
    return leftPointer;
  }

  private static void print(int arr[]) {
    System.out.println("Sorted array: ");
    for (int i : arr) {
      System.out.println(i);
    }
  }

  public static void main(String[] args) {
    int arr[] = { 1, 4, -2, 53, 65, 876, 918, 565 };
    quickSort(arr, 0, arr.length - 1);
    print(arr);

  }
}
