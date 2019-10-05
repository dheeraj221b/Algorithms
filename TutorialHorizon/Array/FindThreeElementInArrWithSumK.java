import java.util.Arrays;

/**
 * FindThreeElementInArrWithSumK
 * 
 * Objec­tive: Given an array of integer write an algorithm to find 3 elements
 * that sum to a given number k. In short a+b+c = k.
 * 
 * Example:
 * 
 * int a [] = { 3,1,7,4,5,9,10} , k = 21;Output: Elements are 7 4 10
 * 
 * int a [] = { 3,1,7,4,5,9,10} , k = 55;
 * 
 * Output: Did not find 3 elements whose sum is 55
 * 
 */
public class FindThreeElementInArrWithSumK {
    public static void main(String[] args) {
        int arr[] = { 3, 1, 7, 4, 5, 9, 10 };
        int k = 21;

        int len = arr.length;
        Arrays.sort(arr);

        for (int i = 0; i < len; i++) {
            int a = arr[i];

            int res = k - a;
            int j = i + 1;
            int l = len - 1;

            while (j < l) {
                int sum = arr[j] + arr[l];
                if (sum == res) {
                    System.out.println("Elements are: " + a + " " + arr[j] + " " + arr[l]);
                    return;
                } else {
                    if (sum > res) {
                        l--;
                    } else {
                        j++;
                    }
                }

            }
        }

    }
}