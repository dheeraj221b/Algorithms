import java.util.Arrays;

/**
 * FindNumberOfReversePair
 * 
 * Objective: Given an array of integers A[],find no of reverse pairs means no
 * of (i, j) pairs where i < j and A[i]>A[j].
 * 
 * Example:
 * 
 * A[] = {10, 3, 4, 2, 5, 7, 9, 11}
 * 
 * Output:7 Reversed pairs: (10, 3) (10, 4) (10, 2) (10, 5) (10, 7) (10, 9) (3,
 * 2) (4, 2) = 8
 * 
 */
public class FindNumberOfReversePair {
    public static void main(String[] args) {
        int A[] = { 10, 3, 4, 2, 5, 7, 9, 11 };

        System.out.println("Naive Approach");
        // Naive Approach
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] > A[j]) {
                    System.out.println(A[i] + ":" + A[j]);
                }
            }
        }

        System.out.println("Divide and Conquer Approach");
        // Divide and Conquer
        findNumberOfReversePair(A, 0, A.length - 1);
    }

    public static void findNumberOfReversePair(int arr[], int low, int high) {

        if (low >= high) {
            return;
        }

        int mid = (low + high) / 2;

        findNumberOfReversePair(arr, low, mid);
        findNumberOfReversePair(arr, mid + 1, high);

        merge(arr, low, mid, high);
    }

    public static void merge(int arr[], int start, int mid, int high) {
        int left[] = new int[mid - start + 1];
        int right[] = new int[high - mid];

        for (int i = start; i <= mid; i++) {
            left[i - start] = arr[i];
        }

        for (int i = mid + 1; i <= high; i++) {
            int index = i - (mid + 1);
            right[index] = arr[i];
        }

        Arrays.sort(left);
        Arrays.sort(right);

        int i = 0;
        int j = 0;

        while (i < left.length && j < right.length) {
            if (left[i] > right[j]) {
                System.out.println(left[i] + ":" + right[j]);
                j++;
            } else {
                i++;
                j = 0;
            }
        }
    }

}