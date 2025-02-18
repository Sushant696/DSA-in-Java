package Backtracking;

public class PermInt {

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    static void FindPermutations(int arr[], int index) {
        if (index == arr.length) {
            System.out.println("");
            printArray(arr);
            return;
        }

        for (int i = index; i < arr.length; i++) {
            swap(arr, i, index);
            FindPermutations(arr, index + 1);
            swap(arr, i, index);

        }
    }

    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

        int arr[] = {1, 2, 3};
        FindPermutations(arr, 0);
    }
}
