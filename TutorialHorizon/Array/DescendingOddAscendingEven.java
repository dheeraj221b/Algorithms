import java.util.Arrays;

/**
 * DescendingOddAscendingEven
 * 
 * Objctive: Sort an Array such that the odd numbers appear first followed by
 * the even numbers . The odd numbers in ascending order and the even numbers in
 * descending order.
 */
public class DescendingOddAscendingEven {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        int i = 0;
        int j = 0;
        while (i < arr.length && j < arr.length) {
            if (arr[i] % 2 == 0) {
                i++;
            } else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
                j++;
            }
        }

        int index = findEvenNumberIndex(arr, 0, arr.length - 1);
        System.out.println("Even number index: " + index);
        sortOddArr(arr, 0, index - 1);
        sortEvenArr(arr, index, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static int findEvenNumberIndex(int[] arr, int low, int high) {

        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;

        if (low == mid && arr[low] % 2 == 0) {
            return low;
        }

        if (arr[mid] % 2 == 0) {
            return findEvenNumberIndex(arr, low, mid);
        } else {
            return findEvenNumberIndex(arr, mid + 1, high);
        }
    }

    // use quick sort
    public static void sortOddArr(int arr[], int low, int high) {

        if (low > high) {
            return;
        }
        int pivot = arr[high];

        int i = low;
        int start = low;

        while (i < high) {
            if (arr[i] > pivot) {
                int temp = arr[i];
                arr[i] = arr[start];
                arr[start] = temp;

                start++;
                i++;
            } else {
                i++;
            }
        }

        if (start < high) {
            int temp = arr[start];
            arr[start] = arr[high];
            arr[high] = temp;
        }

        sortOddArr(arr, low, start - 1);
        sortOddArr(arr, start + 1, high);
    }

    // use quick sort
    public static void sortEvenArr(int arr[], int low, int high) {
        if (low > high) {
            return;
        }
        int pivot = arr[high];

        int i = low;
        int start = low;

        while (i < high) {
            if (arr[i] < pivot) {
                int temp = arr[i];
                arr[i] = arr[start];
                arr[start] = temp;

                start++;
                i++;
            } else {
                i++;
            }
        }

        if (start < high) {
            int temp = arr[start];
            arr[start] = arr[high];
            arr[high] = temp;
        }

        sortEvenArr(arr, low, start - 1);
        sortEvenArr(arr, start + 1, high);
    }

}