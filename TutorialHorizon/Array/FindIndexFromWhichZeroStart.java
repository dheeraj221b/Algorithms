/**
 * FindIndexFromWhichZeroStart
 */
public class FindIndexFromWhichZeroStart {
    public static void main(String[] args) {
        // int[] a = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0 };
        int[] a = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0 };
        int index = findIndex(a, 0, a.length - 1);
        System.out.println("0 starting index is: " + index);
    }

    public static int findIndex(int arr[], int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;

        if (mid - 1 >= 0 && arr[mid] == 0 && arr[mid - 1] == 1) {
            return mid;
        } else {
            if (arr[mid] == 1) {
                return findIndex(arr, mid + 1, high);
            } else {
                return findIndex(arr, low, mid - 1);
            }
        }
    }

}