/**
 * FindThirdLargest
 */
public class FindThirdLargest {

    public static void main(String[] args) {
        // int[] arrA = new int[] { 6, 8, 1, 9, 2, 1, 10 };
        int[] arrA = { 6, 8, 1, 9, 2, 1, 10, 10 };
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE, third = Integer.MIN_VALUE;

        for (int i = 0; i < arrA.length; i++) {
            if (arrA[i] > first) {
                third = second;
                second = first;
                first = arrA[i];
            } else if (arrA[i] > second) {
                third = second;
                second = arrA[i];
            } else if (arrA[i] > third) {
                third = arrA[i];
            }
        }
        System.out.println(third);

    }
}