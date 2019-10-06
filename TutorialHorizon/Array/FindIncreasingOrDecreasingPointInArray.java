/**
 * FindIncreasingOrDecreasingPointInArray
 * 
 * Objec­tive: Given an array of integer which is first increasing then
 * decreasing. Find the element in array from which point it starts decreasing.
 * OR Given an array of integer which is first increasing then decreasing. Find
 * the maximum element in that array.
 * 
 * Example:
 * 
 * int [] a =
 * {1,2,4,6,11,15,19,20,21,31,41,51,55,46,35,24,18,14,13,12,11,4,2,1};
 * 
 * output: 55
 * 
 * int [] a = {1,2,4}; //no deceasing element, so last element will be answer
 * output: 4
 * 
 * int [] a = {4,2,1}; //no deceasing element, so last element will be answer
 * output: 4
 */
public class FindIncreasingOrDecreasingPointInArray {
    public static void main(String[] args) {
        // int[] a = { 1, 2, 4, 6, 11, 15, 19, 20, 21, 31, 41, 51, 54, 55, 46, 35, 24,
        // 18, 14, 13, 12, 11, 4, 2, 1 };

        // int a[] = { 1, 2, 3, 4 };
        // int a[] = { 1, 2 };
        int[] a = { 4, 2, 1 };
        findPoint(a, 0, a.length - 1);
    }

    public static void findPoint(int arr[], int low, int high) {

        int mid = (low + high) / 2;

        if (high == low) {
            System.out.println(arr[low]);
            return;
        }
        if (low == high - 1) {
            if (arr[low] > arr[high]) {
                System.out.println(arr[low]);
            } else {
                System.out.println(arr[high]);
            }
            return;
        }

        if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
            System.out.println(arr[mid]);
        } else {
            if (arr[mid] > arr[mid + 1]) {
                findPoint(arr, low, mid);
            } else {
                findPoint(arr, mid + 1, high);
            }
        }

    }

}