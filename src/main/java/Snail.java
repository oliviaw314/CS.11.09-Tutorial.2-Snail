public class Snail {

    /**
     *
     * TODO 5
     *
     * Input: an n x n 2d array.
     * Output: a 1d array of length n^2 that contains the order of elements visited in a snail traversal of the 2d array.
     *
     * Example:
     *
     * Input:
     *
     * {
     *     {1,2}
     *     {3,4}
     *
     *     {1,2,3},
     *     {4,5,6},
     *     {7,8,9}
     *
     *     {1,2,3,4}
     *     {4,5,6,7}
     *     {8,9,10,11}
     *     {12,13,14,15}
     * }
     *
     * Output:
     *
     * {1,2,3,6,9,8,7,4,5}
     *
     * @param array2d
     * @return a 1d array containing the order of elements visited in a snail traversal of the 2d array.
     *         returns an empty array if array2d is not square.
     */
    public static int[] flattenSnail(int[][] array2d) {
        if (array2d==null || array2d.length==0 || !isPerfectSquare(array2d)) {
            return new int[0];
        }
        int rowsCol = array2d.length;
        int[] result = new int[rowsCol*rowsCol];
        int t=0; int b=rowsCol-1; int l=0; int r=rowsCol-1; int ind=0;
        while (t<=b && l<=r) { //since top and right both start at 0
            for (int i=l; i<=r; i++) {
                result[ind++]=array2d[t][i];
            }
            t++;
            for (int i=t; i<=b; i++) {
                result[ind++]=array2d[i][r];
            }
            r--;
            for (int i=r; i>=l; i--) {
                result[ind++]=array2d[b][i];
            }
            b--;
            for (int i=b; i>=t; i--) {
                result[ind++]=array2d[i][l];
            }
            l++;
        }
        return result;
    }
    /**
     *
     * TODO 6
     *
     * Input: a 1d array of length n, where n is a perfect square.
     * Output: a 2d array of width == height == sqrt(n) that represents a snail.
     *
     * Example:
     *
     * Input:
     *
     * {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
     *
     * Output:
     *
     * {
     *     {1,2,3,4,5},
     *     {16,17,18,19,6},
     *     {15,24,25,20,7},
     *     {14,23,22,21,8},
     *     {13,12,11,10,9},
     * }
     *
     *
     * @param array1d
     * @return a 2d array of width == height == sqrt(n), where n is the length of the inputted array, that represents a snail.
     *         returns an empty 2d array if the length of array1d is not a perfect square.
     */
    public static int[][] makeSnail(int[] array1d) {
        if (array1d==null || array1d.length==0 || !isPerfectSquare(array1d)) {
            return new int[0][0];
        }
        // finding the square root of array1d length
        int rowsCol = (int) Math.sqrt(array1d.length);
        int[][] result = new int[rowsCol][rowsCol];
        int t=0; int b=rowsCol-1; int l=0; int r=rowsCol-1; int ind=0;
        while (t<=b && l<=r) { //since top and right both start at 0
            for (int i=l; i<=r; i++) {
                result[t][i]=array1d[ind++];
            }
            t++;
            for (int i=t; i<=b; i++) {
                result[i][r]=array1d[ind++];
            }
            r--;
            for (int i=r; i>=l; i--) {
                result[b][i]=array1d[ind++];
            }
            b--;
            for (int i=b; i>=t; i--) {
                result[i][l]=array1d[ind++];
            }
            l++;
        }
        return result;
    }

    /**
     *
     * TODO 1
     *
     * Private helper method that prints the contents of a 1d array.
     * Used mainly for debugging purposes.
     *
     * @param array1d
     */
    private static void print1dArray(int[] array1d) {
        for (int number : array1d) {
            System.out.println(number);
        }
    }

    /**
     *
     * TODO 2
     *
     * Private helper method that prints the contents of a 2d array.
     * Used mainly for debugging purposes.
     *
     * @param array2d
     */
    private static void print2dArray(int[][] array2d) {
        for (int[] numberArray : array2d) {
            for (int number : numberArray) {
                System.out.println(number);
            }
        }
    }

    /**
     *
     * TODO 3
     *
     * Private helper method that checks to see if a 1d array is of a length that is a perfect square.
     *
     * @param array1d
     * @return
     */
    private static boolean isPerfectSquare(int[] array1d) {
        for (int i=0; i*i<=array1d.length; i++) {
            if (i*i==array1d.length) {
                return true;
            }
        }
        return false;
    }


    /**
     *
     * TODO 4
     *
     * Private helper method that checks to see if a 2d array is a square.
     *
     * @param array2d
     * @return
     */
    private static boolean isPerfectSquare(int[][] array2d) {
        // have to do for loop to check each row since the array at each index might be of diff lengths
        for (int[] array1d : array2d) {
            if (array1d.length!=array2d.length) {
                return false;
            }
        }
        return true;
    }


}
