import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;

/**
 * SortArrayDefinedByOtherArray
 */
public class SortArrayDefinedByOtherArray {

    public static int auxArr[];

    public static void main(String[] args) {
        int input[] = { 2, 6, 9, 1, 4, 4, 2, 1, 10, 13, 5, 7, 8 };
        auxArr = new int[input.length];

        int otherArr[] = { 1, 2, 4, 6 };

        Hashtable<Integer, Integer> table = new Hashtable<>();

        for (int i = 0; i < input.length; i++) {

            int num = input[i];
            if (table.containsKey(num)) {
                int count = table.get(num);
                table.put(num, count + 1);
            } else {
                table.put(num, 1);
            }
        }

        // Implementation of merge sort
        sortInputArr(input, 0, input.length - 1);
        int index = 0;
        int tempArr[] = new int[input.length];
        for (int i = 0; i < otherArr.length; i++) {
            int num = otherArr[i];
            if (table.containsKey(num)) {
                int count = table.get(num);
                for (int j = 0; j < count; j++) {
                    tempArr[index] = num;
                    index++;
                }
            }
            table.remove(num);
        }

        for (int i = 0; i < input.length; i++) {
            int num = input[i];
            if (table.containsKey(num)) {
                tempArr[index] = num;
                index++;
            }
        }

        System.out.println(Arrays.toString(tempArr));

    }

    public static void sortInputArr(int arr[], int low, int high) {
        if (low >= high) {
            return;
        }

        int mid = (low + high) / 2;
        sortInputArr(arr, low, mid);
        sortInputArr(arr, mid + 1, high);

        merge(arr, low, mid, high);
    }

    public static void merge(int arr[], int low, int mid, int high) {

        for (int i = low; i <= high; i++) {
            auxArr[i] = arr[i];
        }

        int i = low;
        int j = mid + 1;
        int k = low;
        while (i <= mid && j <= high) {
            if (auxArr[i] < auxArr[j]) {
                arr[k] = auxArr[i];
                i++;
            } else {
                arr[k] = auxArr[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            arr[k] = auxArr[i];
            k++;
            i++;
        }

        while (j <= high) {
            arr[k] = auxArr[j];
            k++;
            j++;
        }
    }

}