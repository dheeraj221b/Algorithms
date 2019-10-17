/**
 * FindCommonElement3Arrays
 */
public class FindCommonElement3Arrays {

    public static void main(String[] args) {
        int[] A = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int[] B = { 1, 3, 5, 6, 7, 8, 12 };
        int[] C = { 2, 3, 4, 5, 8, 9 };

        int i = 0, j = 0, k = 0;

        while (i < A.length && j < B.length && k < C.length) {
            if (A[i] == B[j] && A[i] == C[k]) {
                System.out.print(A[i] + " ");
                i++;
                j++;
                k++;
            } else if (A[i] <= B[j] && A[i] <= C[k]) {
                i++;
            } else if (B[j] <= A[i] && B[j] <= C[k]) {
                j++;
            } else {
                k++;
            }
        }
        System.out.println();
    }
}