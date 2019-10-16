import java.util.Arrays;

/**
 * SearchElementInRotatedSortedArray
 */
public class SearchElementInRotatedSortedArray {

    public static void main(String[] args) {
        int a[] = { 10, 11, 12, 1, 2, 3, 4, 5, 6, 7, 8 };

        int num = 1;
        System.out.println(Arrays.toString(a));
        int index = findElement(a, num, 0, a.length - 1);
        System.out.println("Index of element " + num + " is: " + index);
    }

    public static int findElement(int arr[], int num, int low, int high) {

        System.out.println("Low: " + low + " High:" + high);

        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;

        if (arr[mid] == num) {
            return mid;
        }

        if (arr[mid] > arr[low]) {
            if (arr[mid] > num && arr[low] <= num) {
                return findElement(arr, num, low, mid - 1);
            } else {
                return findElement(arr, num, mid + 1, high);
            }
        } else {
            if (arr[mid] < num && arr[high] >= num) {
                return findElement(arr, num, mid + 1, high);
            } else {
                return findElement(arr, num, low, mid - 1);
            }
        }

    }

}