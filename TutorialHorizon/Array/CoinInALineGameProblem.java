/**
 * CoinInALineGameProblem
 */
public class CoinInALineGameProblem {

    public static int aliceMax = Integer.MIN_VALUE;
    public static int bobMax = 0;

    public static void main(String[] args) {
        int[] B = { 6, 9, 1, 2, 16, 8 };

        // Solution using recursion
        findMaxValueByRecursion(B, 0, B.length - 1, 0, 0, true);

        System.out.println("Alice: " + aliceMax + " Bob: " + bobMax);
    }

    public static void findMaxValueByRecursion(int arr[], int start, int end, int alice, int bob, boolean isAliceTurn) {
        if (alice >= aliceMax) {
            aliceMax = alice;
            bobMax = bob;
        }

        if (start > end) {
            return;
        }

        if (isAliceTurn) {
            findMaxValueByRecursion(arr, start + 1, end, alice + arr[start], bob, !isAliceTurn);
            findMaxValueByRecursion(arr, start, end - 1, alice + arr[end], bob, !isAliceTurn);
        } else {
            if (arr[start] > arr[end]) {
                findMaxValueByRecursion(arr, start + 1, end, alice, bob + arr[start], !isAliceTurn);
            } else {
                findMaxValueByRecursion(arr, start, end - 1, alice, bob + arr[end], !isAliceTurn);
            }
        }
    }

}