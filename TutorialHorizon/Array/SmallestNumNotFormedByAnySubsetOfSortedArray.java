/**
 * SmallestNumNotFormedByAnySubsetOfSortedArray
 */
public class SmallestNumNotFormedByAnySubsetOfSortedArray {
    public static void main(String[] args) {
        // int[] arr = { 1, 1, 3, 4, 6, 7, 9 };
        // int[] arr = { 1, 1, 1, 1, 1 };
        // int arr[] = { 2, 3, 6, 7 };
        int[] arr = { 1, 2, 6, 7, 9 };
        int smallestNo = 1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > smallestNo) {
                break;
            } else {
                smallestNo = smallestNo + arr[i];
            }
        }
        System.out.println("Smallest num which can not be formed: " + smallestNo);
    }
}