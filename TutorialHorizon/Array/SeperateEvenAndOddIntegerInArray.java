import java.util.Arrays;

/**
 * SeperateEvenAndOddIntegerInArray
 */
public class SeperateEvenAndOddIntegerInArray {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 6, 8, 7, 12 };

        int i = 0; // even
        int j = arr.length - 1; // odd

        while (i < j) {
            if (arr[i] % 2 != 0 && arr[j] % 2 == 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
                j--;
            } else if (arr[i] % 2 == 0 && arr[j] % 2 != 0) {
                i++;
                j--;
            } else if (arr[i] % 2 != 0 && arr[j] % 2 != 0) {
                i--;
            } else {
                i++;
            }
        }
        System.out.println(Arrays.toString(arr));

    }
}