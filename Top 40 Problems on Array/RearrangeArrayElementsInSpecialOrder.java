import java.util.Arrays;

/**
 * RearrangeArrayElementsInSpecialOrder
 * 
 * Objec­tive: Given an array of integers of size 2n, write an algorithm to
 * arrange them such that first n elements and last n elements are set up in
 * alternative manner. Say n = 3 and 2n elements are {x1, x2, x3, y1, y2, y3} ,
 * then result should be {x1, y1, x2, y2, x3, y3}
 * 
 * Example: A [] = {1, 3, 5, 7, 9, 2, 4, 6, 8, 10}, n= 5 Output: {1, 2, 3, 4, 5,
 * 6, 7, 8, 9, 10}
 */

public class RearrangeArrayElementsInSpecialOrder {

    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 7, 2, 4, 6, 8 };
        // int n = 4;

        // Naive Approach
        // System.out.println("Naive Approach");
        // rearrangeArrayNaiveApproach(arr, n);

        // DivideAndConquerApproach
        System.out.println("Divide and Conquer Approach - only works for 2 ^ i number of elements in array");
        rearrangeArrayDivideAndConquerApproach(arr);
    }

    public static void rearrangeArrayNaiveApproach(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            int index = n + i;
            int num = arr[index];

            int pos = 2 * i + 1;
            for (int j = index; j > pos; j--) {
                arr[j] = arr[j - 1];
            }
            arr[pos] = num;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void rearrangeArrayDivideAndConquerApproach(int arr[]) {
        int start = 0;
        rearrange(arr, start, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static void rearrange(int arr[], int start, int end) {
        if (end > start + 1) {
            int size = (end - start) / 2;
            swapNewArray(arr, start + size / 2, size);
            int mid = (start + end) / 2;
            rearrange(arr, start, mid);
            rearrange(arr, mid, end);
        }
    }

    public static void swapNewArray(int arr[], int start, int size) {
        int newArraySize = size / 2;
        for (int i = start; i < start + newArraySize; i++) {
            int temp = arr[i];
            arr[i] = arr[i + newArraySize];
            arr[i + newArraySize] = temp;
        }
    }

}