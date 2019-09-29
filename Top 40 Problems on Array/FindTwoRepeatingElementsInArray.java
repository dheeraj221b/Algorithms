/**
 * FindTwoRepeatingElementsInArray
Objective: Given an array of n+2 elements. All elements of the array are in range 1 to n 
and all elements occur once except two numbers which occur twice. 
Write an algorithm to find the two repeating numbers.

Example:

int [] A = {1,4,5,6,3,2,5,2};
int n = 6;
Output: Two Repeated elements are: 2 and 5
 */
public class FindTwoRepeatingElementsInArray {

    public static void main(String[] args) {
        int [] A = {1,4,5,6,3,2,5,2};
        int n = 6;
        boolean arr[] = new boolean[n];

        System.out.println("Two Numbers are: ");
        for(int i=0;i<A.length;i++){
            if(!arr[A[i]-1]){
                arr[A[i]-1] = true;
            }else{
                System.out.println(A[i]);
            }
        }
    }
}