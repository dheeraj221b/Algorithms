/**
 * FindThirdHighestElement
 * 
 * Objective: Given an array of integers, write an algorithm to find the third
 * smallest element in the array.
 * 
 * Example:
 * 
 * Int [] a = { 6, 8, 1, 9, 2, 10}; Output: Third smallest element is: 6
 * 
 * Int [] a = { 6, 8, 1, 9, 2, 1, 10, 10}; Output: Third smallest element is: 2
 * 
 * Int [] a = {6}; Output: Invalid Input, array size is less than 3
 */
public class FindThirdSmallestElement {

    public static void main(String[] args) {
        int[] arrA = new int[] { 6, 8, 1, 9, 2, 10 };

        if (arrA.length < 3) {
            System.out.println("Array length is less than 3.");
            return;
        }

        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE, third = Integer.MAX_VALUE;
        for (int i = 0; i < arrA.length; i++) {
            if (arrA[i] < third) {
                if (arrA[i] < second) {
                    if (arrA[i] < first) {
                        third = second;
                        second = first;
                        first = arrA[i];
                    } else {
                        third = second;
                        second = arrA[i];
                    }
                } else {
                    third = arrA[i];
                }
            }
        }
        System.out.println(third);
    }
}