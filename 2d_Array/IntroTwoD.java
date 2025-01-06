

class IntroTwoD {
    public static void main(String[] args) {

        // creation of 2d array
        int[][] twodArr = new int[5][5];
        twodArr[0][0] = 1;

        // init and populate
        int[][] array = { { 1, 2, 3, 8 }, { 1, 2, 3 } };
        System.out.println(array[1].length);

        System.out.println(array.length + "hell");
        for (int i = 0; i < array.length; i++) {

            System.out.println();
        }
        for (int j = 0; j < array[1].length; j++) {
            System.out.print(array[j] + " ");
        }

    }
}