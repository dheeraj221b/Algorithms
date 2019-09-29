/**
 * MaximumSubarrayProblem
Objec­tive:  The max­i­mum sub­ar­ray prob­lem is the task of find­ing the con­tigu­ous sub­ar­ray 
within a one-dimensional array of num­bers which has the largest sum.

Exam­ple:

int [] A = {−2, 1, −3, 4, −1, 2, 1, −5, 4};
Output: contiguous subarray with the largest sum is 4, −1, 2, 1, with sum 6.
 */
public class MaximumSubarrayProblem {

    public static void main(String[] args) {
        int A[] = { 1, 2, -3, -4, 2, 7, -2, 3 };

        int sum = A[0];
        int largestSum = A[0];

        for (int i = 1; i < A.length; i++) {
            if(sum + A[i] > A[i]){
                sum = sum + A[i];
            }else{
                sum = A[i];
            }

            if(sum > largestSum){
                largestSum = sum;
            }
        }
        System.out.println("Largest Sum is: "+ largestSum);
    }
}