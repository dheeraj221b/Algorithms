import java.util.Arrays;

/**
 * RearrangePositiveNegativeElementAtAlternetPosition
 */
public class RearrangePositiveNegativeElementAtAlternetPosition {

    public static void main(String[] args) {
        int[] arrA = { 1, 2, -3, -4, -5, 6, -7, -8, 9, 10, -11, -12, -13, 14 };

        // do first round of quick sort by taking pivot as 0
        int i = -1;
        for (int j = 0; j < arrA.length; j++) {
            if (arrA[j] < 0) {
                i++;
                int temp = arrA[j];
                arrA[j] = arrA[i];
                arrA[i] = temp;
            }
        }

        int j = 1;
        int positiveIndex = i + 1;
        while (j < arrA.length && positiveIndex < arrA.length) {

            int temp = arrA[positiveIndex];
            arrA[positiveIndex] = arrA[j];
            arrA[j] = temp;

            positiveIndex++;
            j = j + 2;
        }
        System.out.println(Arrays.toString(arrA));
    }
}