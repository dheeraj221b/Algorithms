import java.util.Arrays;

/**
 * MergeSort
 */
public class MergeSort {
    static int auxArr[];
    static int inputArr[];

    public static void main(String[] args) {
        inputArr = new int[] { 2, 1, 6, 3, 9, 4, 5, 10 };
        auxArr = new int[inputArr.length];
        mergeSort(inputArr);
        System.out.println("Sorted arr: " + Arrays.toString(inputArr));
    }

    public static void mergeSort(int arr[]) {
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int arr[], int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            sort(arr, low, mid);
            sort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    public static void merge(int arr[], int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            auxArr[i] = inputArr[i];
        }

        int i = low;
        int j = mid + 1;
        int k = low;

        while (i <= mid && j <= high) {
            if (auxArr[i] > auxArr[j]) {
                inputArr[k] = auxArr[j];
                j++;
            } else {
                inputArr[k] = auxArr[i];
                i++;
            }
            k++;
        }

        while (i <= mid) {
            inputArr[k] = auxArr[i];
            i++;
            k++;
        }

    }

}