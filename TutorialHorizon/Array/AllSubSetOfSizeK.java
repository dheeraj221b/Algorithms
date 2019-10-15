import java.util.Arrays;

/**
 * AllSubSetOfSizeK
 */
public class AllSubSetOfSizeK {

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 };
        int k = 3;
        int newArr[] = new int[k];
        printAllSubsetOfSizeK(arr, newArr, 0, 0, k);
    }

    public static void printAllSubsetOfSizeK(int arr[], int newArr[], int start, int current, int k) {

        if (current == k) {
            System.out.println(Arrays.toString(newArr));
            return;
        }

        if (start >= arr.length) {
            return;
        }

        // either select
        newArr[current] = arr[start];
        printAllSubsetOfSizeK(arr, newArr, start + 1, current + 1, k);

        // or ignore
        printAllSubsetOfSizeK(arr, newArr, start + 1, current, k);
    }

}