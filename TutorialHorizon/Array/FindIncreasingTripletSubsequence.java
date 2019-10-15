/**
 * FindIncreasingTripletSubsequence
 */

// Todo
public class FindIncreasingTripletSubsequence {

    public static void main(String[] args) {
        int arr[] = { 10, 9, 4, 3, 2, 1, 7, 3, 1, 11, 2, 6, 9 };

        // O(n^3)
        findTripletsNaive(arr);

        // O(n)
        findTripletBetterSolution(arr);
    }

    public static void findTripletsNaive(int arr[]) {
        int size = arr.length - 1;
        for (int i = 0; i < arr.length - 3; i++) {
            for (int j = size; j >= i + 2; j--) {
                for (int k = j - 1; k > i; k--) {
                    if (arr[k] < arr[j] && arr[i] < arr[k]) {
                        System.out.println(arr[i] + " " + arr[k] + " " + arr[j]);
                    }
                }
            }
        }
    }

    public static void findTripletBetterSolution(int arr[]) {
        int lMin[] = new int[arr.length];
        int rMax[] = new int[arr.length];

        lMin[0] = 0;
        rMax[arr.length - 1] = arr.length - 1;

        int minSoFar = arr[0];
        int maxSoFar = arr[arr.length - 1];

        int j = arr.length - 2;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < minSoFar) {
                minSoFar = arr[i];
                lMin[i] = i;
            } else {
                lMin[i] = lMin[i - 1];
            }

            if (j >= 0 && arr[j] > maxSoFar) {
                rMax[j] = j;
                maxSoFar = arr[j];
            } else {
                rMax[j] = rMax[j + 1];
            }
            j--;
        }
    }

}