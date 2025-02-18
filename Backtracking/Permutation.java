package Backtracking;

/**
 * Permutation
 */
public class Permutation {

    // static void FindPermutations(String str, String permutation) {
    //     if (str.length() == 0) {
    //         System.out.println(permutation);
    //         return;
    //     }
    //     for (int i = 0; i < str.length(); i++) {
    //  *        extracting the individual character
    //         char currChar = str.charAt(i);
    //  *         getting the remaining subString
    //         String remainStr = str.substring(0, i) + str.substring(i + 1);
    //  *         recursion for backtracking
    //         FindPermutations(remainStr, permutation + currChar);
    //     }
    // }
    private static void printArray(String[] arr) {
        String result = String.join("", arr);
        System.out.print(result);
    }

    static void FindPermutations(String[] arr, int index) {
        // Base case: when index reaches array length
        if (index == arr.length) {
            printArray(arr);
            return;
        }
        // Try each character as next in permutation
        for (int i = index; i < arr.length; i++) {
            // Swap current index with i
            swap(arr, index, i);
            // Recurse with next index
            FindPermutations(arr, index + 1);
            // Backtrack by swapping back
            swap(arr, index, i);
        }
    }

    static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        String str = "abc";
        String arr[] = str.split("");

        FindPermutations(arr, 0);
    }
}
