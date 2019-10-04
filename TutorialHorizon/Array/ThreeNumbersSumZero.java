import java.util.Arrays;

/**
 * ThreeNumbersSumZero
 * 
 * Objec­tive: Given an array of integer write an algorithm to find 3 elements
 * that sum to a zero. In short a+b+c = 0.
 * 
 * Example
 * 
 * int a [] = { 3,-1,-7,-4,-5,9,10};
 *
 * Elements are -4 9 -5
 */
public class ThreeNumbersSumZero {
    public static void main(String[] args) {

        // Use sorting -> a + b + c = 0
        // reduce problem to b + c = -a

        int arr[] = { 3, -1, -7, -4, -5, 9, 10 };
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {

            int a = -arr[i];

            int start = i + 1;
            int end = arr.length - 1;

            while (start < end) {
                int tempSum = arr[start] + arr[end];
                if (tempSum == a) {
                    System.out.println("Found 3 elements whose sum is 0");
                    System.out.println((-a) + "  " + arr[start] + "  " + arr[end]);
                    return;
                } else if (tempSum > a) {
                    end--;
                } else {
                    start++;
                }
            }
        }
    }
}