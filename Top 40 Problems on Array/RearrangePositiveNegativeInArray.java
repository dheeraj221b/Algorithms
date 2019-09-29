import java.util.Arrays;

/**
 * RearrangePositiveNegativeInArray
 */
public class RearrangePositiveNegativeInArray {
    public static void main(String[] args) {
        int[] a = { 1, -2, -3, -4, 5, -6, 7, -8, 9, -10, -11, -12, 20 };
        rearrangeArray(a, 0, a.length - 1);
    }

    public static void rearrangeArray(int arr[], int low, int high) {
        for (int i = high; i >= low; i--) {
            int current = i;
            while (arr[current] > 0 && (current + 1) <= high && arr[current + 1] < 0) {
                int temp = arr[current];
                arr[current] = arr[current + 1];
                arr[current + 1] = temp;
                current++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

}