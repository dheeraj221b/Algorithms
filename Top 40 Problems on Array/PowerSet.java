/**
 * PowerSet
 * 
 * Objective: Given a set of numbers, print all the posssible subsets of it
 * including empty set.
 * 
 * Power Set: In mathematics, PowerSet of any given set S, PS(S) is set of all
 * subsets of S including empty set. Example:
 * 
 * S ={1,2,3}
 * 
 * PS(S): {{ᵩ}, {1}, {2}, {3}, {1, 2}, {1, 3}, {2, 3}, {1, 2, 3}}.
 */
public class PowerSet {

    public static int[] A = { 1, 2, 3, 4 };

    public static void generateAllPowerSetByRecursion(int B[], int index) {
        if (index == B.length) {
            for (int i = 0; i < B.length; i++) {
                if (B[i] == 1) {
                    System.out.print(A[i] + " ");
                }
            }
            System.out.println();
            return;
        }
        B[index] = 0;
        generateAllPowerSetByRecursion(B, index + 1);
        B[index] = 1;
        generateAllPowerSetByRecursion(B, index + 1);
    }

    public static void generateAllPowerSetGeneral() {
        int len = A.length;
        int totalCombination = (int) Math.pow(2, len);
        for (int i = 0; i < totalCombination; i++) {
            for (int j = 0; j < len; j++) {
                if ((i & (1 << j)) > 0) {
                    System.out.print(A[j]);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        // Recursion
        int B[] = new int[A.length];
        generateAllPowerSetByRecursion(B, 0);
        System.out.println("By Second Approach");
        // Second Approach
        generateAllPowerSetGeneral();
    }

}