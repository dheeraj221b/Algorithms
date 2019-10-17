/**
 * OccurrencesInSortedArray
 */
public class OccurrencesInSortedArray {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 2, 2, 2, 2, 2, 3, 4, 5, 5, 6 };
        int x = 2;

        int startIndex = findStartIndex(arr, 0, arr.length - 1, x);
        int endIndex = findEndIndex(arr, 0, arr.length - 1, x);

        if (startIndex != -1) {
            int occurance = endIndex - startIndex + 1;
            System.out.println(x + " occur " + occurance + " times");
        } else {
            System.out.println("No occurance ");
        }

    }

    public static int findStartIndex(int arr[], int low, int high, int x) {
        if (low > high) {
            return -1;
        }
        if (low == high && arr[low] != x) {
            return -1;
        }

        int mid = (low + high) / 2;

        if (mid == low && arr[low] == x) {
            return low;
        }

        if (arr[mid] >= x) {
            return findStartIndex(arr, low, mid, x);
        } else {
            return findStartIndex(arr, mid + 1, high, x);
        }
    }

    public static int findEndIndex(int arr[], int low, int high, int x) {

        if (low > high) {
            return -1;
        }

        if (low == high) {
            if (arr[low] == x) {
                return low;
            } else {
                return -1;
            }
        }

        if (low + 1 == high) {
            if (arr[high] == x) {
                return high;
            } else if (arr[low] == x) {
                return low;
            }
            return -1;
        }

        int mid = (low + high) / 2;

        if (arr[mid] > x) {
            return findEndIndex(arr, low, mid - 1, x);
        } else {
            return findEndIndex(arr, mid, high, x);
        }
    }

}