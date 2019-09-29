import java.util.Arrays;

/**
 * MergeKSortedArray
 * 
 * Objective: Given k sorted array, write an algorithm to merge Them into One
 * sorted array.
 * 
 * Example :
 * 
 * int[][] A = new int[5][];
 * 
 * A[0] = new int[] { 1, 5, 8, 9 }; A[1] = new int[] { 2, 3, 7, 10 }; A[2] = new
 * int[] { 4, 6, 11, 15 }; A[3] = new int[] { 9, 14, 16, 19 }; A[4] = new int[]
 * { 2, 4, 6, 9 };
 * 
 * Output: [1, 2, 2, 3, 4, 4, 5, 6, 6, 7, 8, 9, 9, 9, 10, 11, 14, 15, 16, 19]
 */
public class MergeKSortedArray {

    public static void main(String[] args) {
        int[][] A = new int[5][];
        A[0] = new int[] { 1, 5, 8, 9 };
        A[1] = new int[] { 2, 3, 7, 10 };
        A[2] = new int[] { 4, 6, 11, 15 };
        A[3] = new int[] { 9, 14, 16, 19 };
        A[4] = new int[] { 2, 4, 6, 9 };

        resultArrayUsingNaiveApproach(A);
    }

    public static void resultArrayUsingNaiveApproach(int A[][]) {
        int row = A.length;
        int col = A[0].length;

        int pos[] = new int[row];
        int sortedArr[] = new int[row * col];

        for (int i = 0; i < row * col; i++) {

            int small = Integer.MAX_VALUE;
            int rowIndex = 0;
            int colIndex = 0;

            for (int j = 0; j < row; j++) {
                int currentIndex = pos[j];
                if (currentIndex == col) {
                    continue;
                }

                int num = A[j][currentIndex];
                if (num < small) {
                    small = num;
                    rowIndex = j;
                    colIndex = currentIndex + 1;
                }
            }
            pos[rowIndex] = colIndex;
            sortedArr[i] = small;
        }

        System.out.println(Arrays.toString(sortedArr));
    }
}