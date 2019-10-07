/**
 * MaximumSubarrayProblem
 */
public class MaximumSubarrayProblem {

    public static void main(String[] args) {
        // int[] A = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int[] A = { -2, 12, -5, 10, -1, -6, 4 };
        int previousSum = A[0];

        int max = A[0];

        for (int i = 1; i < A.length; i++) {
            if (A[i] + previousSum > A[i]) {
                previousSum = A[i] + previousSum;
            } else {
                previousSum = A[i];
            }

            if (previousSum > max) {
                max = previousSum;
            }
        }

        System.out.println("Max is: " + max);

    }
}