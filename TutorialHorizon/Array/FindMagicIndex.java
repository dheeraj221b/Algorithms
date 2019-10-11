/**
 * FindMagicIndex
 * 
 * Objective: Magic Index – Find Index In Sorted Array Such That A[i] = i.
 * 
 */
public class FindMagicIndex {

    public static void main(String[] args) {
        // int[] A = { -1, 0, 1, 2, 4, 10 };
        int A[] = { 1, 2, 3, 3, 4, 5, 6, 7, 8, 9, 10 };
        int magicIndex = findMagicIndex(A, 0, A.length - 1);
        System.out.println("Magic Index: " + magicIndex);
    }

    public static int findMagicIndex(int arr[], int low, int high) {

        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;
        if (arr[mid] == mid) {
            return mid;
        } else {
            if (mid > arr[mid]) {
                return findMagicIndex(arr, mid + 1, high);
            } else {
                return findMagicIndex(arr, low, mid - 1);
            }
        }
    }

}