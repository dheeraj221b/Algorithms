/**
 * MaxDiffBwTwoNumbers
 */
public class MaxDiffBwTwoNumbers {

    public static void main(String[] args) {
        int[] a = { 2, 8, 1, 6, 10, 4 };
        findGap(a);
        int[] b = { 10, 30, 5, 16, 19 };
        findGap(b);
    }

    public static void findGap(int arr[]) {
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }

            if (arr[i] < min) {
                min = arr[i];
            }
        }

        System.out.println("Maximum Difference: " + (max - min));
    }
}