
import java.util.Arrays;

class Init {

    public static void main(String[] args) {
        int[][] numbers; // numbers = null
        int[][] numbers1 = new int[2][3];
        // numbers1 = [{0,0},{0,0,}] two arrays where first element is one array second element is another array and first [] index is to select the array and then second [] for selecting specific values of that array.

        //  creating new array with elements on the go 
        int[][] newArr = {{1, 3, 4, 3}, {42, 132, 2, 1}};
        // iterating and displaying the content of the arary.
/*
 *
    

 0 |1  3   4  3  |
 1 |42 132 2  1  |
 0    1  2  3
 
 00
 10
 01
 11
 02
 12
 02
 22
         */

        // for (int i = 0; i < newArr.length; i++) {
        //     for (int j = 0; j < newArr[i].length; j++) {
        //         System.out.print(newArr[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        // first select subarray or the row to which you want to iterate and then in the second find the length of the subarray and start printing elements
// using to string method to print the array
        System.out.println(Arrays.toString(newArr)); // prints the two sub array that are inside of the array
        //todo [ [I@jasd433 [I@jasd433  ]

        System.out.println(Arrays.deepToString(newArr)); // display the content of the arrays

        /*
         todo [ [1, 3, 4, 3], [42, 132, 2, 1] ]
         */
    }

}
