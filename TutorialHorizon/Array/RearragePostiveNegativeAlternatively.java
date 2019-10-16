import java.util.Arrays;

/**
 * RearragePostiveNegativeAlternatively
 */
public class RearragePostiveNegativeAlternatively {

    public static void main(String[] args) {
        int[] arrA = { 1, 2, -3, -4, -5, 6, -7, -8, 9, 10, -11, -12, -13, 14 };

        // Better Solution : Time Complexity : O(n) Space Complexity: O(1)
        // Use Quick sort technique.

        // Take the pivot element as 0 and do the first round of Quick Sort.
        // After above step you will have all the negative elements on left and all the
        // positive elements on the right.

        // Then just the every alternate element in the left half (negative elements)
        // with the elements in the right (positive elements)

        int index = 0;
        for (int i = 0; i < arrA.length; i++) {

            if (arrA[i] < 0) {
                int temp = arrA[i];
                arrA[i] = arrA[index];
                arrA[index] = temp;
                index++;
            }
        }

        int start = 1;
        for (int i = index; i < arrA.length; i++) {
            int temp = arrA[start];
            arrA[start] = arrA[i];
            arrA[i] = temp;
            start = start + 2;
        }
        System.out.println(Arrays.toString(arrA));
    }
}