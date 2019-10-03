/**
 * PrintAllSubsequenceOfArray
 */
public class PrintAllSubsequenceOfArray {

    public static void main(String[] args) {

        int[] arrInput = { 1, 2, 3 };

        int res = (int) Math.pow(2, arrInput.length);

        for (int i = 1; i <= res; i++) {
            for (int j = 0; j < arrInput.length; j++) {
                if ((i & (1 << j)) > 0) {
                    System.out.print(arrInput[j] + " ");
                }
            }
            System.out.println();
        }
    }
}