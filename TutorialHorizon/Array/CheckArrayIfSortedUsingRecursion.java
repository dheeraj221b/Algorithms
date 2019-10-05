/**
 * CheckArrayIfSortedUsingRecursion
 */
public class CheckArrayIfSortedUsingRecursion {
    public static void main(String[] args) {
        // int[] a = { 1, 2, 3, 4 };
        // int[] a = { 1, 2, 3, 4, 2 };
        int[] a = { 1, 2, 3, 4, 8, 8, 22, 50 };
        checkArrayIfSorted(a, 0);
    }

    public static void checkArrayIfSorted(int arr[], int low) {

        if (low > arr.length - 2) {
            System.out.println("Array is sorted");
            return;
        }

        if (arr[low] <= arr[low + 1]) {
            checkArrayIfSorted(arr, low + 1);
        } else {
            System.out.println("Array is not sorted");
        }
    }

}