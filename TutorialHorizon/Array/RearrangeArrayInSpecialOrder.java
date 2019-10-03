import java.util.Arrays;

/**
 * RearrangeArrayInSpecialOrder
 * 
 * 
 * A [] = {1, 3, 5, 7, 9, 2, 4, 6, 8, 10},
 * 
 * n= 5
 * 
 * Output: {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
 */
public class RearrangeArrayInSpecialOrder {
    public static void main(String[] args) {

        // Approach Brute Force
        int arr[] = { 1, 3, 5, 7, 9, 2, 4, 6, 8, 10 };

        rearrangeWithNaiveApproach(arr);

        int[] A = { 1, 3, 5, 7, 2, 4, 6, 8 };
        rearrangeWithDivideAndConquer(A, 0, A.length);

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(A));
    }

    public static void rearrangeWithNaiveApproach(int arr[]) {
        int n = arr.length / 2;

        int j = n;
        int i = 1;

        while (i < j && j < arr.length) {
            int num = arr[j];
            for (int k = j; k >= i; k--) {
                arr[k] = arr[k - 1];
            }
            arr[i] = num;
            i = i + 2;
            j++;
        }
    }

    // This solution will work only if total number of elements is in 2i So total
    // elements are either 2 or 4 or 8 or 16 ….and so on.
    // 2. Total length is 2n, take n elements around middle element.
    // 3.Swap n/2 elements on left side from the middle element with n/2 elements on
    // the right side from the middle element.
    // 4.Now divide the array into 2 parts, first n elements and last n elements.
    // 5.Repeat the step 2, 3 on both the parts recursively.
    public static void rearrangeWithDivideAndConquer(int arr[], int start, int end) {

        int half = (end - start) / 2;

        if (half < 2) {
            return;
        }

        int s = start + (half / 2);
        int tempMid = s + (half / 2);

        int j = tempMid;
        for (int i = s; i < tempMid; i++) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            j++;
        }

        int mid = (start + end) / 2;
        rearrangeWithDivideAndConquer(arr, start, mid);
        rearrangeWithDivideAndConquer(arr, mid, end);

    }

}