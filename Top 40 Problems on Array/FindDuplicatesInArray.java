/**
 * FindDuplicatesInArray
Objective: Given an array of integers, find out duplicates in it.

Example:

int [] a = {4, 6, 2, 1, 2, 5};
Output: Array has duplicates : 2

int a [] = {1, 6, 5, 2, 3, 3, 2};
Output: Array has duplicates : 2 , 3
 */
public class FindDuplicatesInArray {

    public static void main(String[] args) {
        int a[] = {1, 6, 5, 2, 3, 3, 2};

        //Approaches: Sorting(O(nlogn), using merge sort), HashMap(O(n)), Double for loop(O(n^2))

        //Better Approach - This solution works only if array has positive integers and all the 
        //elements in the array are in range from 0 to n-1 where n is the size of the array.

        System.out.println("Following numbers are duplicate");
        for (int i = 0; i < a.length; i++) {
            if(a[Math.abs(a[i])] < 0){
                System.out.println(Math.abs(a[i]));
            }
            else{
                a[Math.abs(a[i])] = a[Math.abs(a[i])] * -1;
            }
        }
    }
}