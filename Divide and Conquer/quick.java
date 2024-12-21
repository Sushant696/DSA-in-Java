public class quick {

  private static void quickSort(int arr[], int start, int end) {
    if (start < end) {
      int p = partitions(arr, start, end);
      quickSort(arr, start, p - 1);
      quickSort(arr, p + 1, end);
    }
  }

  private static int partitions(int arr[], int start, int end) {
    int low = start + 1;
    int high = end;
    int pivot = arr[start];

    while (low <= high) {
      while (low <= high && arr[low] <= pivot) {
        low++;
      }
      while (low <= high && arr[high] > pivot) {
        high--;
      }
      if (low < high) {
        swap(arr, low, high);
      }
    }

    swap(arr, start, high);
    return high;
  }

  static void swap(int arr[], int a, int b) {
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }

  public static void main(String[] args) {
    int arr[] = { 5, 1, 3, 9, 2, 4 };

    System.out.println("Original Array:");
    for (int j : arr) {
      System.out.print(j + " ");
    }

    quickSort(arr, 0, arr.length - 1);

    System.out.println("\nSorted Array:");
    for (int i : arr) {
      System.out.print(i + " ");
    }
  }

}
