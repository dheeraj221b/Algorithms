import java.util.Arrays;

/**
 * RearrangeArrayOfGivenRange
 */
public class RearrangeArrayOfGivenRange {

    public static void main(String[] args) {
        // int A[] = { -1, -1, 6, 1, 9, 3, 2, -1, 4, -1 };
        int A[] = { 19, 7, 0, 3, 18, 15, 12, 6, 1, 8, 11, 10, 9, 5, 13, 16, 2, 14, 17, 4, };

        for (int i = 0; i < A.length; i++) {
            int num = A[i];

            while (num != -1 && num != i) {
                int temp = A[num];
                A[i] = temp;
                A[num] = num;
                num = temp;
            }
        }
        System.out.println(Arrays.toString(A));
    }
}