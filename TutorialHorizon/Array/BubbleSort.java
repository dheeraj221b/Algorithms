import java.util.Arrays;

/**
 * BubbleSort
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arrA = { 5, 1, 9, 3, 2, 10 };

        boolean isSwapped;
        for (int i = 0; i < arrA.length - 1; i++) {
            isSwapped = false;
            for (int j = 0; j < arrA.length - 1; j++) {
                if (arrA[j] > arrA[j + 1]) {
                    isSwapped = true;
                    int temp = arrA[j];
                    arrA[j] = arrA[j + 1];
                    arrA[j + 1] = temp;
                }
            }

            if (!isSwapped) {
                break;
            }

        }
        System.out.println(Arrays.toString(arrA));
    }
}